package edu.mum.estore.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mum.estore.service.ProductService;
@Component
public class ShoppingCard {
	
	@Autowired
	ProductService productService;
	
	private static List<Product> products=new ArrayList<Product>();
	public  List<Product> getProduct() {
		return products;
	}
	
	public void addProduct(Product product,long quantity){
		
		long lockNumber=product.getLockNumber()+quantity;
		product.setLockNumber(lockNumber);
		productService.update(product);
		products.add(product);
	}	
	public void removeProduct(Product product,long quantity){
			int index=products.indexOf(product);
			long lockNumber=product.getLockNumber()-quantity;
			product.setLockNumber(lockNumber);
			productService.update(product);
			products.remove(index);
		}
}
