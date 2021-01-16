package com.jakuza.vendingmachine;

import com.jakuza.vendingmachine.model.ResponseProduct;
import com.jakuza.vendingmachine.model.VendingMachine;
import com.jakuza.vendingmachine.service.VendingMachineService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class VendingMachineServiceTest {

    VendingMachine vendingMachine = new VendingMachine("test");
    VendingMachineService vendingMachineService = new VendingMachineService(vendingMachine);

    {
        vendingMachine.addProduct("Cola", 25);
    }

    @BeforeAll
    static void beforeAll() {
    }

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

    @Test
    void getBackChooseProduct() {
        ResponseProduct responseProduct = vendingMachineService.selectProduct("Cola");
        assertThat(responseProduct.getProduct().getName()).isEqualTo("Cola");
    }
}
