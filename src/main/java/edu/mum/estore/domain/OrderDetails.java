package edu.mum.estore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderDetails {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private long id;
private long productId;
private String productName;
private int quantity;
private float unitCost;
private float subTotal;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public long getProductId() {
	return productId;
}
public void setProductId(long productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public float getUnitCost() {
	return unitCost;
}
public void setUnitCost(float unitCost) {
	this.unitCost = unitCost;
}
public float getSubTotal() {
	return subTotal;
}
public void setSubTotal(float subTotal) {
	this.subTotal = subTotal;
}
}
