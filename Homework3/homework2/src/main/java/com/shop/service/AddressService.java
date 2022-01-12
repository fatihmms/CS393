package com.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.model.Address;
import com.shop.repo.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	

	
	public Address save(Address address) {
		return addressRepository.save(address);
	}
	


}
