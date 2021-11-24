package com.yair.model;

public abstract class Shop {
    public Shop(Person owner, Person cashier, float cashInRegister, boolean isClosed, String name) {
        this.owner = owner;
        this.cashier = cashier;
        this.cashInRegister = cashInRegister;
        this.isClosed = isClosed;
        this.name = name;
    }
    protected String name;
    protected Person owner;
    protected Person cashier;
    protected float cashInRegister = 0;
    protected boolean isClosed = true;

    public Shop(String name) {
        this.name = name;
    }

    public Shop(Person owner, Person cashier, String name) {
        this.owner = owner;
        this.cashier = cashier;
        this.name = name;
    }
    public abstract void print();
    public abstract float tax(float num);
    public static Shop compareCashIn(Shop s1, Shop s2) {
        Shop s = null;
        if (s1.cashInRegister > s2.cashInRegister) {
            s = s1;
        } else if (s2.cashInRegister > s1.cashInRegister) {
            s = s2;
        }
        return s;
    }
    public void open(){
        isClosed = false;
        System.out.println("the shop is opened now!");
    }
    public void close (){
        isClosed = true;
        System.out.println("the shop is closed now!");
    }
    public abstract void purcashItem(float amounyOfMoney, String candy);

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Person getCashier() {
        return cashier;
    }

    public void setCashier(Person cashier) {
        this.cashier = cashier;
    }

    public float getCashInRegister() {
        return cashInRegister;
    }

    public void setCashInRegister(float cashInRegister) {
        this.cashInRegister = cashInRegister;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
