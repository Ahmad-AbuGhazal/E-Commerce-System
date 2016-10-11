package edu.mum.estore.domain;

import java.util.ArrayList;
import java.util.List;


public class OrderHistory {
List<Order> orders=new ArrayList<>();

public List<Order> getOrders() {
	return orders;
}

public void setOrders(List<Order> orders) {
	this.orders = orders;
}
}
