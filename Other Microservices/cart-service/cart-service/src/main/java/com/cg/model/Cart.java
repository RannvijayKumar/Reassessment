package com.cg.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "carttable")
public class Cart implements Serializable{

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;

	@Column
	private int quantity;

	@Column
	private double productPrice;

	@Column
	private String productName;
	
	/*
	 * private Integer userId;
	 * 
	 * private Integer productId;
	 */

	@ManyToOne
	private Product product;
	
	
	@OneToMany(mappedBy = "cartBean1", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<OrderBean> orderBeanList;

	@JsonBackReference(value="abc")
	@OneToOne(/* cascade = CascadeType.ALL, */ fetch = FetchType.LAZY)
	private User user;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Cart(int quantity, double productPrice, String productName,Product product,User user) {
		super();
		
		this.quantity = quantity;
		this.productPrice = productPrice;
		this.productName = productName;
		this.product = product;
		this.user=user;
	}

	public Cart(Integer cartId, int quantity, double productPrice, String productName, Product product, User user) {
		super();
		this.cartId = cartId;
		this.quantity = quantity;
		this.productPrice = productPrice;
		this.productName = productName;
		this.product = product;
		this.user = user;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", quantity=" + quantity + ", productPrice=" + productPrice + ", productName="
				+ productName + ", product=" + product + ", user=" + user + "]";
	}

}
