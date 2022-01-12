package com.shop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shop.dto.ShopAndProductDTO;
import com.shop.dto.ShopDTO;
import com.shop.model.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {

	 @Query("select NEW com.shop.dto.ShopDTO(s.id, s.name) from Shop s")
	 public List<ShopDTO> getShops();
	 
	 @Query("select NEW com.shop.dto.ShopAndProductDTO(s.id, s.name) from Shop s where id=?1")
	 public ShopAndProductDTO getShopById(int id);
	 
}
