package com.shop.dto;

import java.util.List;

public class OrderDTO {

    public int amount;
    public List<Integer> products;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<Integer> getProducts() {
        return products;
    }

    public void setProducts(List<Integer> products) {
        this.products = products;
    }
}
