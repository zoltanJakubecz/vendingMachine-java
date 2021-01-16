package com.jakuza.vendingmachine.model;

public enum Coins {

    PENNY("penny", 1),
    NICKEL("nickel", 5),
    DIME("dime", 10),
    QUARTER("quarter", 25);

    private final String name;
    private final Integer value;

    Coins(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }


}
