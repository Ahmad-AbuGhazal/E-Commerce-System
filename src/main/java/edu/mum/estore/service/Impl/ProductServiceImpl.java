package edu.mum.estore.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import edu.mum.estore.domain.Product;
import edu.mum.estore.repository.ProductRepository;
import edu.mum.estore.rest.RemoteApi;
import edu.mum.estore.service.ProductService;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	RemoteApi remoteApi;
	@Override
	public void addProduct(Product product) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		HttpEntity<Product> httpEntity = new HttpEntity<Product>(product, remoteApi.getHttpHeaders());
		restTemplate.exchange("http://localhost:8080/olafbackend/addItem/", HttpMethod.POST, httpEntity, Product.class);
		
	}

	@Autowired
	ProductRepository productRepository;
	@Override
	public String searchProduct(long productId) {
		
		return productRepository.searchProduct(productId);
	}

}
