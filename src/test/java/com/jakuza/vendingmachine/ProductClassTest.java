package com.jakuza.vendingmachine;

import com.jakuza.vendingmachine.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductClassTest {

    @Test
    void sanityCheck() {
        Product product = new Product("Jaffa", 66);
        assertThat(product).isNotNull();
    }

    @Test
    void getProductName() {
        Product coca = new Product("Coca Cola", 45);
        Assertions.assertEquals("Coca Cola",coca.getName());
    }
}
