package com.jbac.app.items.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbac.app.items.customers.ProductClientRest;
import com.jbac.app.items.models.Item;

@Service("serviceFeign")
//@Primary
public class ItemServiceFeign implements ItemService {

	
	@Autowired
	private ProductClientRest clientFeign;
	
	@Override
	public List<Item> findAll() {
		return clientFeign.listProduct()
				.stream()
				.map(p->new Item(p,1))
				.collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer quantity) {
		return new Item(clientFeign.getProduct(id),quantity);
	}

}
