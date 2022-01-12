package com.shop.dto;

import java.util.ArrayList;
import java.util.List;

public class ShopAndProductDTO {

	private int id;
	
	private String name;
	
	private List<ProductDTO> products=new ArrayList<>();
	
	public ShopAndProductDTO() {
		super();
		
	}
	
	public ShopAndProductDTO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<ProductDTO> getProducts() {
		return products;
	}


	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}


}
