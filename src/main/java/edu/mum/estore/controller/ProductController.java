package edu.mum.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.estore.domain.Product;
import edu.mum.estore.service.ProductService;

@RestController
public class ProductController {
	private static final String DEFULT_STATUS="NOT FOUND";
	@Autowired
	ProductService productService;
	
	
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/product/addproduct/{product}", method = RequestMethod.POST)
	public void addProduct(@PathVariable("product") Product product) {
			productService.addProduct(product);
	}

	
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/product/api/productid/{productid}", method = RequestMethod.GET)
	public String searchProduct(@PathVariable("productid") long productId) {
		String status=DEFULT_STATUS;
		if(productId!=0)
		{
			 status=productService.searchProduct(productId);
		}
		
		return status;
	}

}
