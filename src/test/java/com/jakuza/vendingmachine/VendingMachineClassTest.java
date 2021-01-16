package com.jakuza.vendingmachine;

import com.jakuza.vendingmachine.model.VendingMachine;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class VendingMachineClassTest {

    VendingMachine vendingMachine = new VendingMachine("test");


    @Test
    void sanityTest() {
        assertThat(vendingMachine).isNotNull();
    }

    @Test
    void getMachineName() {
        Assertions.assertEquals("test", vendingMachine.getName());
    }

}
