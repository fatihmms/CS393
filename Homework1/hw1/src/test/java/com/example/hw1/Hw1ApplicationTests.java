package com.example.hw1;

import com.example.hw1.model.*;
import com.example.hw1.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class Hw1ApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ShopRepository shopRepository;

	@Autowired
	AddressRepository addressRepository;

	@Test
	void test() {

		Customer customer1 = new Customer();
		customer1.setFirstName("Fatih");
		customer1.setLastName("Memis");

		Customer customer2 = new Customer();
		customer2.setFirstName("Gizem");
		customer2.setLastName("Gormus");

		Shop shop1 = new Shop();
		shop1.setName("Teknosa");
		shop1.setAddress_of_shop("GAZIOSMANPASA MAH");

		Product product1 = new Product();
		product1.setPrice(12000);
		product1.setName("Iphone");

		Product product2 = new Product();
		product2.setName("Samsung");
		product2.setPrice(22000);

		Order order1 = new Order();
		order1.setAmount(5);

		Order order2 = new Order();
		order2.setAmount(3);

		Address address1 = new Address();
		address1.setCity("Istanbul");
		address1.setText("esenler mah");

		Address address2 = new Address();
		address2.setCity("Canakkale");
		address2.setText("esenler mah. caliskanlar apt.");
		customer2.setAddress(address2);
		customer1.setAddress(address1);
		product1.setProductShop(shop1);
		product2.setProductShop(shop1);
		order1.getProducts().add(product1);
		order1.getProducts().add(product2);
		order2.getProducts().add(product1);
		customer1.setShop(shop1);
		customer2.setShop(shop1);

		order1.setCustomer(customer1);


		orderRepository.save(order1);

		customerRepository.save(customer1);
		customerRepository.save(customer2);


	}

}
