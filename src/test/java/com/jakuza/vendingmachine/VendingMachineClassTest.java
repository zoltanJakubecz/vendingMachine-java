package com.jakuza.vendingmachine;

import com.jakuza.vendingmachine.model.Vend;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.assertj.core.api.Assertions.assertThat;



public class VendingMachineClassTest {
    @Test
    void sanitaryTest() {
        Vend vend = new Vend();
//        Assertions.assertNotEquals(null, vend);
        assertThat(vend).isNotNull();
    }
}
