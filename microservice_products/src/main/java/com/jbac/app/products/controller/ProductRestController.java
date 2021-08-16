package com.jbac.app.products.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbac.app.products.entities.Product;
import com.jbac.app.products.services.IProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductRestController {
	
	//Para utilizar con Feign
	@Autowired
	private Environment env;
	
	//Para utilizar con RestTemplate
	@Value("${server.port}")
	private Integer port;
	
	@Autowired
	IProductService productService;
	
	@GetMapping
	public List<Product> getListProducts(){
		return productService.findAll()
				.stream().map(product->{
					//product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
					product.setPort(port);
					return product;
				}).collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable("id") Long id) {
		Product product = productService.findById(id);
		//product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		product.setPort(port);
		return product;
	}

}
