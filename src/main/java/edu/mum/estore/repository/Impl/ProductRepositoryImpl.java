package edu.mum.estore.repository.Impl;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.estore.domain.Product;
import edu.mum.estore.repository.ProductRepository;

@Repository
@RestController
public class ProductRepositoryImpl implements ProductRepository{

	@Override
	public void addProduct(Product product) {
		
		
	}

	@Override
	public String searchProduct(long productId) {
		
		return "NOT FOUND";
	}

}
