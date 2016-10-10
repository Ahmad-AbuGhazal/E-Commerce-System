package edu.mum.estore.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Category {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="CAT_ID")
private long id;
@Column(name="CAT_NAME")
private String categoryName;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
}
