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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Coins, Integer> getCoins() {
        return coins;
    }

    public void setCoins(Map<Coins, Integer> coins) {
        this.coins = coins;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public void addProduct(String name, Integer price){
        products.put(new Product(name, price), 1);
    }
}
