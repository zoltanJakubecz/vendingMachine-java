package com.jakuza.vendingmachine;

import com.jakuza.vendingmachine.model.Product;
import com.jakuza.vendingmachine.model.ResponseProduct;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ResponseProductClassTest {

    ResponseProduct responseProduct = new ResponseProduct(new Product("Test", 0), 0, "Test");

    @Test
    void sanityCheck() {
        assertThat(responseProduct).isNotNull();
    }

    @Test
    void getProduct() {
        assertThat(responseProduct.getProduct()).isNotNull();
    }

    @Test
    void getRightMessage() {
        assertThat(responseProduct.getMessage()).isEqualTo("Test");
    }
}
