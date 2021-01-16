package com.jakuza.vendingmachine.service;

import com.jakuza.vendingmachine.model.Coins;
import com.jakuza.vendingmachine.model.VendingMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class VendingMachineService {

    private final VendingMachine vendingMachine;
    private final List<Integer> incomeCounter;

    public VendingMachineService(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        this.incomeCounter = new ArrayList<>();
    }

    public Integer insertCoins(Integer income){
        Stream.of(Coins.values())
                .filter(v -> v.getValue().equals(income))
                .findFirst().ifPresent(coin -> incomeCounter.add(coin.getValue()));
        return incomeCounter.stream().reduce(0, Integer::sum);
    }

    public Integer cancelRequest(){
        incomeCounter.clear();
        return 0;
    }
}
