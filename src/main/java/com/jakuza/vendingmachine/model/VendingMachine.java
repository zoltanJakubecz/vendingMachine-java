package com.jakuza.vendingmachine.model;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    private String name;
    private Map<Coins, Integer> coins;
    private Map<Product, Integer> products;

    public VendingMachine(String name) {
        this.name = name;
        coins = new HashMap<>();
        products = new HashMap<>();
    }
}
