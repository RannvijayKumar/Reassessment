package com.cg.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "orderbean")
public class OrderBean {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;

	
	@Column
	private int customerId;

	@Column
	private int cartId;

	@Column
	private double totalBill;

	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyyy")
	private Date orderDate;

	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cartId_fk", referencedColumnName = "cartId")
	private Cart cartBean1;

	public OrderBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderBean(int customerId, int cartId, double totalBill, Date orderDate, Cart cartBean1) {
		super();

		this.customerId = customerId;
		this.cartId = cartId;
		this.totalBill = totalBill;
		this.orderDate = orderDate;
		this.cartBean1 = cartBean1;
	}
	

	public OrderBean(Integer orderId, int customerId, int cartId, double totalBill, Date orderDate, Cart cartBean1) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.cartId = cartId;
		this.totalBill = totalBill;
		this.orderDate = orderDate;
		this.cartBean1 = cartBean1;
	}



	public int getCustomerId() {
		return customerId;
	}



	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}



	public int getCartId() {
		return cartId;
	}



	public void setCartId(int cartId) {
		this.cartId = cartId;
	}



	public double getTotalBill() {
		return totalBill;
	}



	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}



	public Date getOrderDate() {
		return orderDate;
	}



	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}



	public Cart getCartBean1() {
		return cartBean1;
	}



	public void setCartBean1(Cart cartBean1) {
		this.cartBean1 = cartBean1;
	}



	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}



	@Override
	public String toString() {
		return "OrderBean [orderId=" + orderId + ", customerId=" + customerId + ", cartId=" + cartId + ", totalBill="
				+ totalBill + ", orderDate=" + orderDate + ", cartBean1=" + cartBean1 + "]";
	}

	
	
}
