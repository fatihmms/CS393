package com.shop.controller;

import java.util.List;

import com.shop.dto.OrderDTO;
import com.shop.dto.ProductDTO;
import com.shop.model.Order;
import com.shop.service.OrderService;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.ShopAndProductDTO;
import com.shop.dto.ShopDTO;
import com.shop.model.Shop;
import com.shop.service.ShopService;

@RestController
@RequestMapping("/shops")
public class ShopController {
	@Autowired
	ShopService service;

	@Autowired
	ProductService productService;

	@Autowired
	OrderService orderService;

	@GetMapping
	public List<ShopDTO> getShops(){
		return service.getShops();
	}
	@PostMapping
	public Shop addShop(@RequestBody Shop shop){
		return service.save(shop);
	}
	@DeleteMapping("/{id}")
	public void deleteShop(@PathVariable int id){
		 service.delete(id);
	}
	
	@GetMapping("/{id}")
	public ShopAndProductDTO getShop(@PathVariable int id){
		 return service.findByIdAndProductPrice(id,200.0);
	}

	@GetMapping("/products")
	public List<ProductDTO> getProducts(){return productService.getProducts();}

	@PostMapping("/order")
	public OrderDTO createOrder(@RequestBody OrderDTO order){return orderService.createOrder(order);}
}
