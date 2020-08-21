package com.cg.service;

import java.util.List;

import com.cg.models.Product;


public interface ProductInterface {
	public List<Product> retriveAllProducts();
	
	public void add (Product product);
	
	public Product editProduct(  Product product);
	
	public List<Product> delete( int id);
}
