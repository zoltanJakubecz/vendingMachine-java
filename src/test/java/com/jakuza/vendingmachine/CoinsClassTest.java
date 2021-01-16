package com.jakuza.vendingmachine;

import com.jakuza.vendingmachine.model.Coins;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class CoinsClassTest {

    @Test
    void getTheNameOfEnumItem() {
        String dime = Coins.DIME.getName();
        Assertions.assertEquals("dime", dime);
    }

    @Test
    void getTheValueOfEnumItem() {
        Integer quarter = Coins.QUARTER.getValue();
        Assertions.assertEquals(25, quarter);
    }
}
