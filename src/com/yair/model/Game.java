package com.yair.model;

public class Game {
    public Game(String name, float price) {
        this.name = name;
        this.price = price;
    }

    private String name;
    private float price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
