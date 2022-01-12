package com.shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
