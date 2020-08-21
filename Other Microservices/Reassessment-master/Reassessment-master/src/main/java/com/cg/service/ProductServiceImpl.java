package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.models.Product;
import com.cg.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductInterface {

	@Autowired
	ProductRepository repository;

	@Override
	public List<Product> retriveAllProducts() {
		return repository.findAll();
	}

	@Override
	public void add(Product product) {
		repository.save(product);
		
	}

	@Override
	public Product editProduct(Product product) {
		Product prod = 	repository.save(product);
		return prod;
	}

	@Override
	public List<Product> delete(int id) {
		repository.deleteById(id);
		return repository.findAll();
	}

	
	

}
