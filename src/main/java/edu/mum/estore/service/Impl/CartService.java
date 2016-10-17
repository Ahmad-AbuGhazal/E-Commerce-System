package edu.mum.estore.service.Impl;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import edu.mum.estore.domain.ShoppingCard;

@Component
public class CartService {
	private HashMap<String, ShoppingCard> cart=new HashMap<>();
	
	public CartService() {}

	public HashMap<String, ShoppingCard> getCart() {
		return cart;
	}

	public void setCart(HashMap<String, ShoppingCard> cart) {
		this.cart = cart;
	}
}
