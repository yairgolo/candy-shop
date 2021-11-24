package com.yair.model;

public class CandyShop extends Shop  {

    Candy c1 = new Candy("apple", 3);
    Candy c2 = new Candy("grape", 4);
    Candy c3 = new Candy("watermelon", 5);
    Candy[] candyArr = {c1, c2, c3};

    public static CandyShop getShop(String name){
        CandyShop newShop = new CandyShop(name);
        return newShop;
    }
    public CandyShop(Person owner, Person cashier, String name) {
        super(owner, cashier, name);
    }

    public CandyShop(String name) {
        super(name);
    }

    public void print(){
        for (int i = 0; i < candyArr.length; i++) {
            System.out.println(candyArr[i].getName());
        }
    }

    @Override
    public float tax(float num) {
        float newNum = (float) (num * 1.1);
        return newNum;
    }

    @Override
    public void purcashItem(float amounyOfMoney, String candy) {
        for (int i = 0; i < candyArr.length; i++) {
            if (candy.equals(candyArr[i].getName())){
                float newPrice = tax(candyArr[i].getPrice());
                if (newPrice <= amounyOfMoney){
                    cashInRegister += newPrice;
                    System.out.println("take your '" + candyArr[i].getName() + "' candy and your money " + (amounyOfMoney - newPrice) );
                } else {
                    System.out.println("not enough money");
                }
                return;
            }
        }
        System.out.println("the candy is not find");
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public String getName() {
        return super.getName();
    }

}
