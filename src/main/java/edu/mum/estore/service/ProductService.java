package edu.mum.estore.service;

import java.util.List;

import edu.mum.estore.domain.Product;

public interface ProductService {
	
	 void addProduct(Product product);
	 List<Product> searchProduct(String productName, String productCategory);
     Product getProductByName(long vendorId,String productName);
     Product get(long productId);
     boolean isAvailable(Product product,long quantity);
     Product update(Product product);
     List<Product> findProductsByVendorId(long vendorId);
}
