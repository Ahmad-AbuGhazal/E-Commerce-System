package edu.mum.estore.repository;

import edu.mum.estore.domain.Product;

public interface ProductRepository {
	public void addProduct(Product product);
	public String searchProduct(long productId);
}
