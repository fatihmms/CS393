package com.example.hw1.controller;

import com.example.hw1.model.Product;
import com.example.hw1.model.Shop;
import com.example.hw1.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shops")
public class ShopController {

    @Autowired
    ShopService shopService;

    @GetMapping
    List<Shop> all(){
        return shopService.getAll();
    }

    @PostMapping
    public Shop saveShop (@RequestBody Shop data){
        return shopService.save(data);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id){
        shopService.deleteById(id);
    }






}
