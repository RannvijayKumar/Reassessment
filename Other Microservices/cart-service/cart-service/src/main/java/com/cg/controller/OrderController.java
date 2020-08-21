package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dao.OrderDao;
import com.cg.model.Cart;
import com.cg.repository.CartRepository;
import com.cg.repository.OrderRepository;
import com.cg.repository.ProductRepository;
import com.cg.repository.UserRepository;

@RestController
public class OrderController {

		@Autowired
		private OrderRepository repository;
		
		@Autowired
		CartRepository cartRepository;
		
		@Autowired
		ProductRepository productRepository;
		@Autowired
		UserRepository userRepository;
		@Autowired
		OrderDao orderDao;
		
		@PostMapping(path = "/addrOrder",
				consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
		public void addOrderByCustomer(@RequestParam("userId") int userId) {
			
//			
			
			
		}
		
		
		@GetMapping(path="/findByCartId/{id}")
		public List<Cart> findById(@PathVariable int id) {
			 System.out.println("inside findById of Controller" );
			//return repository.findAll();
			 
			 return orderDao.viewcartByCustomerId(id);
		}
	
}
