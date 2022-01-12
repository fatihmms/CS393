package com.shop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shop.dto.ProductDTO;
import com.shop.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	 @Query("select new com.shop.dto.ProductDTO(p.id, p.name, p.price) from Shop s inner join s.products p where s.id=?1 and p.price>?2")
	 public List<ProductDTO> findByShopIdAndPrice(int id, double price);


}
