package edu.mum.estore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Product_Table")
public class Product {
	@Id
	@Column(name="ProductID")
	private long productId;
	@Column(name="ProductName")
	private String productName;
	@Column(name="ProductPrice")
	private double productPrice;
	@Column(name="ProductQuantity")
	private long productQuantity;
	@JsonIgnore
	@Transient
	private MultipartFile productImage;
	
	@ManyToOne
	private Vendor vendor;
	
	
	
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	@OneToOne
	private Category category;
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public MultipartFile getProductImage() {
		return productImage;
	}
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public long getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(long productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	

}
