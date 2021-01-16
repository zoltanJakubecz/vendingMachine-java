package com.jakuza.vendingmachine.service;

import com.jakuza.vendingmachine.model.Coins;
import com.jakuza.vendingmachine.model.VendingMachine;

import java.util.ArrayList;
import java.util.List;
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

}
