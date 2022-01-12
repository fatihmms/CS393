package com.shop.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.shop.model.Address;
import com.shop.model.Customer;
import com.shop.model.Product;
import com.shop.model.Shop;
import com.shop.service.AddressService;
import com.shop.service.CustomerService;
import com.shop.service.ProductService;
import com.shop.service.ShopService;
@SpringBootTest
class TestShopService {
	@Autowired
	ShopService shopService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	AddressService addressService;
	

	@Test
	@Commit
	void createShop() {
		Shop shop=new Shop();
		shop.setName("TEKNOLOJI MERKEZI");
		shop.setAddress("MAVI EVLER MAHALLESI. SELCUKBEY CAD. NO: 1");
		shopService.save(shop);
		
		Product product1=new Product();
		product1.setName("IPhone 13 Pro Max");
		product1.setPrice(28500);
		product1.setShop(shop);
		
		Product product2=new Product();
		product2.setName("IPad 9");
		product2.setPrice(3900);
		product2.setShop(shop);
		
		Product product3=new Product();
		product3.setName("Lenovo ThinkPad E14");
		product3.setPrice(15200);
		product3.setShop(shop);
		shop.getProducts().add(product1);
		shop.getProducts().add(product2);
		shop.getProducts().add(product3);
		productService.saveAll(shop.getProducts());
		
		Address address=new Address();
		address.setCity("ISTANBUL");
		address.setText("MAVI EVLER MAHALLESI. SELCUKBEY CAD. NO: 112");
		addressService.save(address);
		
		Customer customer=new Customer();
		customer.setFirstName("ESMA");
		customer.setLastName("MERAL");
		customer.setAddress(address);
		customer.setShop(shop);
		customerService.save(customer);
		
		shop.getCustomers().add(customer);
		
		shopService.save(shop);
	}

}
