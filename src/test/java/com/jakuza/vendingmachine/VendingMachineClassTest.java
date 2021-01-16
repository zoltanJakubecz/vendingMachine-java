package com.jakuza.vendingmachine;

import com.jakuza.vendingmachine.model.VendingMachine;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;



public class VendingMachineClassTest {
    @Test
    void sanitaryTest() {
        VendingMachine vendingMachine = new VendingMachine();
        assertThat(vendingMachine).isNotNull();
    }
}
