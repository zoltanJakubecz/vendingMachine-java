package com.jakuza.vendingmachine.model;

public class ResponseProduct {

    private Product product;
    private Integer change;
    private String message;

    public ResponseProduct(Product product, Integer change, String message) {
        this.product = product;
        this.change = change;
        this.message = message;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
