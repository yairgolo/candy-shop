Import-Module ActiveDirectory -ErrorAction Stop

$config = (Get-ADRootDSE -ErrorAction Stop).configurationNamingContext
$base = "CN=Certificate Templates,CN=Public Key Services,CN=Services,$config"
$lookup = @{}

Get-ADObject -SearchBase $base -LDAPFilter '(objectClass=pKICertificateTemplate)' `
    -Properties 'msPKI-Cert-Template-OID' -ErrorAction Stop |
    ForEach-Object {
        $lookup[$_.Name] = $_.Name
        $oid = $_.'msPKI-Cert-Template-OID'
        if ($oid) { $lookup[$oid] = $_.Name }
    }

$names = foreach ($status in 20, 21) {
    $filter = "RequestID>=1,RequestID<1001,Disposition=$status"
    $csv = certutil.exe -view -restrict $filter -out 'RequestID,CertificateTemplate' csv
    if ($LASTEXITCODE -ne 0) { throw "certutil failed for Disposition=$status" }

    $csv | ConvertFrom-Csv -Header ID, Template | ForEach-Object {
        if ($_.ID -match '^\d+$') {
            $key = ([string]$_.Template).Trim()
            if ($key -match '^(\d+(?:\.\d+)+)(?:\s|$)') { $key = $Matches[1] }
            if ($lookup.ContainsKey($key)) { $lookup[$key] }
        }
    }
}

$file = Join-Path $env:TEMP 'Used-CertificateTemplates.csv'
@('"TemplateName"'; $names | Sort-Object -Unique | ForEach-Object {
    '"' + $_.Replace('"', '""') + '"'
}) | Set-Content -LiteralPath $file -Encoding UTF8 -ErrorAction Stop

Write-Host "CSV: $file"