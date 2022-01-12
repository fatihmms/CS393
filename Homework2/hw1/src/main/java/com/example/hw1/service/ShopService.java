package com.example.hw1.service;

import com.example.hw1.model.Shop;

import java.util.List;

public interface ShopService {
    public Shop save(Shop shop);
    public List<Shop> getAll();
    public Shop getById(int id);
    public void deleteById(int id);
}
