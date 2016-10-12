package edu.mum.estore.repository;

import java.util.List;

import edu.mum.estore.domain.Product;

public interface ProductRepository {
	public void addProduct(Product product);
	public List<Product> searchProduct(String productName,String productCategory);
	Product getProductByName(long vendorId,String productName);
	Product get(long productId);
	Product update(Product product);
}
