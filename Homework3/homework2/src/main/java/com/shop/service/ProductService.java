package com.shop.service;

import java.util.ArrayList;
import java.util.List;

import com.shop.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.model.Product;
import com.shop.repo.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public void saveAll(List<Product> products) {
		for (Product product : products) {
			productRepository.save(product);
		}
	}

	public List<ProductDTO> getProducts(){
		List<Product> products = productRepository.findAll();
		List<ProductDTO> productDTOS = new ArrayList<>();
		for (Product product: products) {
			ProductDTO pDTO = new ProductDTO(product.getId(), product.getName(),product.getPrice());
			productDTOS.add(pDTO);
		}
		return productDTOS;
	}

}
