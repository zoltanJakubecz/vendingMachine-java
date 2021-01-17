package com.jakuza.vendingmachine;

import com.jakuza.vendingmachine.model.Product;
import com.jakuza.vendingmachine.model.ResponseProduct;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ResponseProductClassTest {

    @Test
    void sanityCheck() {
        ResponseProduct responseProduct = new ResponseProduct(new Product("Test", 0), 0);
        assertThat(responseProduct).isNotNull();
    }
}
