package com.cg.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity(name = "producttable")
public class Product {

	@Id
//	@NotNull
//	@Min(1000)
//	@Max(9999)
	private int productId;

	@Column
	@NotEmpty(message = "name should not be empty")
	private String productName;

	@Column
	@org.hibernate.validator.constraints.NotEmpty(message = "Category should not be empty")
	private String productCategory;

	@Column
	private double productPrice;
	
	@Column
	private String productImage;

	@Column
	private String availability;

	@Column
	private String quantity;

	public Product() {
		super();
	}

	

	public Product(int productId, @NotEmpty(message = "name should not be empty") String productName,
			@NotEmpty(message = "Category should not be empty") String productCategory, double productPrice,
			String productImage, String availability, String quantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
		this.productImage = productImage;
		this.availability = availability;
		this.quantity = quantity;
	}



	public String getProductImage() {
		return productImage;
	}



	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}



	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCategory="
				+ productCategory + ", productPrice=" + productPrice + ", availability=" + availability + ", quantity="
				+ quantity + "]";
	}

}
