package com.jakuza.vendingmachine.model;

public class ResponseProduct {

    private Product product;
    private Integer change;

    public ResponseProduct(Product product, Integer change) {
        this.product = product;
        this.change = change;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getChange() {
        return change;
    }

    public void setChange(Integer change) {
        this.change = change;
    }
}
