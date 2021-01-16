package com.jakuza.vendingmachine.service;

import com.jakuza.vendingmachine.model.Coins;
import com.jakuza.vendingmachine.model.VendingMachine;

import java.util.stream.Stream;

public class VendingMachineService {

    private VendingMachine vendingMachine;
    private Integer incomeCounter;

    public VendingMachineService(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        this.incomeCounter = 0;
    }

    public Integer insertCoins(Integer income){
        Stream.of(Coins.values())
                .filter(v -> v.getValue().equals(income))
                .findFirst().ifPresent(coin -> incomeCounter += coin.getValue());
        return incomeCounter;
    }
}
