package com.example.hw1.service;

import com.example.hw1.model.Shop;
import com.example.hw1.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    ShopRepository shopRepository;


    @Override
    public Shop save(Shop shop) {
        return shopRepository.save(shop);
    }

    @Override
    public List<Shop> getAll() {
        return shopRepository.findAll();
    }

    @Override
    public Shop getById(int id) {
        return shopRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        shopRepository.deleteById(id);
    }


}
