package com.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.model.Customer;
import com.shop.repo.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}
	
	

}
