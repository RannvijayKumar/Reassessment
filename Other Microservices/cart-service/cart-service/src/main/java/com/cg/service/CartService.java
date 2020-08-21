package com.cg.service;

import java.util.List;
import java.util.Optional;

import com.cg.model.Cart;

public interface CartService {
	
	public List<Cart> retriveAllProducts();
	
	public void add( String email, int quantity, int productId);
	
	public List<Cart> delete(int id);
	
	public Optional<Cart> findById(int id);
	
	List<Cart> findByUserId(int userId);
	
	
}
