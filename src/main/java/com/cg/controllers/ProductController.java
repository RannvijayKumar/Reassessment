package com.cg.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.models.Product;
import com.cg.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	ProductRepository repository;

	@GetMapping(path = "/products")
	public List<Product> retriveAllProducts() {
		System.out.println("Inside retriveAllProducts() of Controller");
		return repository.findAll();
	}

	@PostMapping(path = "/add")
	public void add(@Valid @RequestBody Product product) {
		System.out.println("Inside add() of Controller");
		repository.save(product);
	}

	@PutMapping(path = "update/{productId}")
	public Product updateStock(@PathVariable int productId, @RequestBody Product product) {
		System.out.println("Inside updateStock() of Controller");
		Product prod = repository.save(product);
		return prod;
	}

	@DeleteMapping(path = "/delete/{id}")
	public List<Product> delete(@PathVariable int id) {
		System.out.println("Inside delete() of Controller");
		repository.deleteById(id);
		return repository.findAll();
	}

}
