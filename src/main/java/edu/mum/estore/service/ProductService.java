package edu.mum.estore.service;

import edu.mum.estore.domain.Product;

public interface ProductService {
	
	public void addProduct(Product product);
	public String searchProduct(long productId);

}
