package com.ecomm.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotEmpty;

//import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {

	@Id
	int id;
   	String productName;
	String productDescription;
	String productSize;
	int productQuantity;
	//@Min(value=1,message="Minimum value for price is 1")
	double productPrice;
	@ManyToOne
	private Category category;
	@Transient
	//private MultipartFile image;
	
	int supplierId;
	int categoryId;
	int price;
	int stock;
	
	//MultipartFile pimage;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductDescription() {
		return productDescription;
	}
	
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	public String getProductSize() {
		return productSize;
	}
	
	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}
	
	public int getProductQuantity() {
		return productQuantity;
	}
	
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	public double getProductPrice() {
		return productPrice;
	}
	
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	/*public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}*/
	
}
