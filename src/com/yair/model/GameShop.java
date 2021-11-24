package com.yair.model;

public class GameShop extends Shop {
    public GameShop(Person owner, Person cashier, String name) {
        super(owner, cashier, name);
    }

    public GameShop(String name) {
        super(name);
    }

    Game g1 = new Game("car", 10);
    Game g2 = new Game("plane", 15);
    Game g3 = new Game("bike", 20);
    Game[] gameArr = {g1, g2, g3};

    public void print(){
        for (int i = 0; i < gameArr.length; i++) {
            System.out.println(gameArr[i].getName());
            }
        }
    public static GameShop getShop(String name) {
        GameShop newShop = new GameShop(name);
        return newShop;
    }
    @Override
    public float tax(float num) {
        float newNum = (float) (num * 1.15);
        return newNum;
    }

    @Override
    public void purcashItem(float amounyOfMoney, String game) {
        for (int i = 0; i < gameArr.length; i++) {
            if (game.equals(gameArr[i].getName())){
                float newPrice = tax(gameArr[i].getPrice());
                if (newPrice <= amounyOfMoney){
                    cashInRegister += newPrice;
                    System.out.println("take your '" + gameArr[i].getName() + "' game and your money " + (amounyOfMoney - newPrice) );
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
