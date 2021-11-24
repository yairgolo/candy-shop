package com.yair;

import com.yair.model.*;

import java.util.Scanner;

public class Main {
    static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {
        Person p1 = new Person("moshe", 30);
        Person p2 = new Person("ayal", 25);
        CandyShop s1 = new CandyShop(p1, p2, "sucaria");
        GameShop s2 = new GameShop(p1, p2, "mishakim");
        System.out.println("the Candy available: ");
        s1.print();
        System.out.println("what you want ?");
        String candy = SCANNER.next();
        System.out.println("insert your money: ");
        s1.purcashItem(SCANNER.nextFloat(), candy);
        System.out.println(s1.getCashInRegister());
        s2.purcashItem(20,"car");
        System.out.println(s2.getCashInRegister());
        System.out.println(Shop.compareCashIn(s1, s2));
        Factory factory = new Factory();
        Shop s3 = factory.getShop(2, "welcome");
        System.out.println(s3);
    }
}
