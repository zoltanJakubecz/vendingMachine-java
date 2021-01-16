package com.jakuza.vendingmachine;

import com.jakuza.vendingmachine.model.Product;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductClassTest {

    @Test
    void sanityCheck() {
        Product product = new Product();
        assertThat(product).isNotNull();
    }
}
