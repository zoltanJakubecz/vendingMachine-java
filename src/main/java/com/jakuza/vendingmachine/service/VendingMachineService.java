package com.jakuza.vendingmachine.service;

import com.jakuza.vendingmachine.model.Coins;
import com.jakuza.vendingmachine.model.Product;
import com.jakuza.vendingmachine.model.ResponseProduct;
import com.jakuza.vendingmachine.model.VendingMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class VendingMachineService {

    private final VendingMachine vendingMachine;
    private final List<Coins> incomeCounter;

    public VendingMachineService(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        this.incomeCounter = new ArrayList<>();
    }

    public Integer insertCoins(Integer income){
        Stream.of(Coins.values())
                .filter(v -> v.getValue().equals(income))
                .findFirst().ifPresent(incomeCounter::add);
        return incomeCounter.stream().map(Coins::getValue).reduce(0, Integer::sum);
    }

    public List<Coins> cancelRequest(){
        incomeCounter.clear();
        return incomeCounter;
    }

    public ResponseProduct selectProduct(String productRequest){
        Map<Product, Integer> products = vendingMachine.getProducts();

        Map.Entry<Product, Integer> productQuantityEntry = products.entrySet().stream()
                .filter(productIntegerEntry -> productRequest.equals(productIntegerEntry.getKey().getName()))
                .findFirst()
                .orElse(null);

        if(productQuantityEntry == null || productQuantityEntry.getValue() == 0)
            return new ResponseProduct(null, 0, "Not available");

        Product product = productQuantityEntry.getKey();
        Integer credit = incomeCounter.stream().map(Coins::getValue).reduce(0, Integer::sum);


        if(credit < product.getPrice())
            return new ResponseProduct(null, 0, "Please insert coins");

        Map<Coins, Integer> coins = vendingMachine.getCoins();

        incomeCounter.forEach(coin -> coins.put(coin, coins.containsKey(coin) ? coins.get(coin) + 1 : 1));
        vendingMachine.setCoins(coins);

        Integer change = credit - product.getPrice();

        return new ResponseProduct(product, change, "Enjoy you drink");
    }

}
