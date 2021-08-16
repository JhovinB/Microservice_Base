package com.jbac.app.products.repository;

import org.springframework.data.repository.CrudRepository;

import com.jbac.app.products.entities.Product;

public interface IProductRepository extends CrudRepository<Product,Long> {

}
