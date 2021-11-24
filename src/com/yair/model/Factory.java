package com.yair.model;


public class Factory {
    public Shop getShop(int num, String name){
        if (num == 1){
            return new GameShop(name);
        } else {
            return new CandyShop(name);
        }
    }
}

