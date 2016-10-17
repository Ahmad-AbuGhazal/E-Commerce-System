package edu.mum.estore.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.estore.domain.Product;
import edu.mum.estore.repository.ProductRepository;
import edu.mum.estore.service.ProductService;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	@Override
	public List<Product> searchProduct(String productName, String productCategory) {
		return productRepository.searchProduct(productName, productCategory);
	}

	@Override
	public void addProduct(Product product) {
		productRepository.addProduct(product);
	}

	@Override
	public Product getProductByName(long vendorId, String productName) {
		return productRepository.getProductByName(vendorId, productName);
	}

	@Override
	public Product get(long productId) {
	 return productRepository.get(productId);
	}

	@Override
	public boolean isAvailable(Product product, long quantity) {
		
		long availableCount=product.getProductQuantity()-product.getLockNumber();
		if(quantity<availableCount){
			return true;
		}
		else{
			return false;
		}	
	}

	@Override
	public Product update(Product product) {
		return productRepository.update(product);
	}
	@Override
	public List<Product> findProductsByVendorId(long vendorId) {
	return productRepository.findProductsByVendorId(vendorId);
	}
	

}
