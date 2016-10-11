package edu.mum.estore.domain;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCard {
	List<Product> products=new ArrayList<Product>();
	public List<Product> getProduct() {
		return products;
	}

	public void setItems(List<Product> items) {
		this.products = items;
	}
}
