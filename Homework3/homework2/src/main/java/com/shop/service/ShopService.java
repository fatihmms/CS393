package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dto.ShopAndProductDTO;
import com.shop.dto.ShopDTO;
import com.shop.model.Shop;
import com.shop.repo.ProductRepository;
import com.shop.repo.ShopRepository;

@Service
public class ShopService {
	@Autowired
	private ShopRepository shopRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public void delete(int id) {
		shopRepository.deleteById(id);
	}
	
	public Shop findById(int id){
		return shopRepository.findById(id).get();
	}
	
	public List<ShopDTO> getShops(){
		return shopRepository.getShops();
	}
	
	public Shop save(Shop shop) {
		return shopRepository.save(shop);
	}
	
	public ShopAndProductDTO findByIdAndProductPrice(int id, double price){
		ShopAndProductDTO	shop=shopRepository.getShopById(id);
		shop.setProducts(productRepository.findByShopIdAndPrice(id, price));
		return shop;
	}
	
}
