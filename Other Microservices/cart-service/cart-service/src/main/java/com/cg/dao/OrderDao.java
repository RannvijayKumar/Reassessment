package com.cg.dao;

import java.util.List;

import com.cg.model.Cart;

public interface OrderDao {
	
	List<Cart> viewcartByCustomerId(int customerId);

}
