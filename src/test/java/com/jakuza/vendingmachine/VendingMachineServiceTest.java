package com.jakuza.vendingmachine;

import com.jakuza.vendingmachine.model.VendingMachine;
import com.jakuza.vendingmachine.service.VendingMachineService;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class VendingMachineServiceTest {

    VendingMachineService vendingMachineService = new VendingMachineService(new VendingMachine("test"));

    @Test
    void sanityCheck() {
        assertThat(vendingMachineService).isNotNull();
    }

    @Test
    void getIncreasedIncomeCounter() {
        assertThat(vendingMachineService.insertCoins(10)).isEqualTo(10);
    }

    @Test
    void resetIncomeCounterWhenTheRequestCancelled() {
        assertThat(vendingMachineService.cancelRequest().size()).isEqualTo(0);
    }
}
