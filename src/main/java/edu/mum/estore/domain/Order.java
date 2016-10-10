package edu.mum.estore.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Order {
@Id
@GeneratedValue
private long id;

private Date orderDate;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public Date getOrderDate() {
	return orderDate;
}

public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
}
}
