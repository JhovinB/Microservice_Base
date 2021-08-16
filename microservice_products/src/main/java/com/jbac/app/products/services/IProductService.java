package com.jbac.app.products.services;

import java.util.List;

import com.jbac.app.products.entities.Product;

public interface IProductService {
	
	public List<Product> findAll();

	public Product findById(Long id);
}
