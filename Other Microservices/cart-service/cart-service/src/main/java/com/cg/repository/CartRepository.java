package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.model.Cart;
import com.cg.model.Product;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	void save(Product product);

}
