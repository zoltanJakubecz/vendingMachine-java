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
        Product product = products.keySet().stream()
                .filter(prod -> productRequest.equals(prod.getName()))
                .findFirst()
                .orElse(null);
        Integer credit = incomeCounter.stream().map(Coins::getValue).reduce(0, Integer::sum);
        product = credit >=0 ? product : null;
        Integer change = product != null ?
                    credit - product.getPrice() :
                    0;
        return new ResponseProduct(product, change);
    }

}
