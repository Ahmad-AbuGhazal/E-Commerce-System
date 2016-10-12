package edu.mum.estore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.estore.domain.Product;
import edu.mum.estore.domain.ResponseInfo;
import edu.mum.estore.domain.ShoppingCard;
import edu.mum.estore.service.ProductService;

@RestController
public class ShoppingController {

	@Autowired
	ShoppingCard shoppingCardService;

	@Autowired
	ProductService ProductService;
	@ResponseBody
	@RequestMapping(value = "/shopping/{productid}/{quanity}")
	public ResponseInfo addProductsToTheSoppingCart(@PathVariable("productid") long productId,
			@PathVariable("quantity") long quantity) {
		ResponseInfo info = new ResponseInfo();
		Product product = ProductService.get(productId);

		if (ProductService.isAvailable(product, quantity)) {
			shoppingCardService.addProduct(product, quantity);
			info.setResponse('Y');
			return info;
		} else {
			info.setResponse('N');
			return info;
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/shopping/{productid}/{quantity}", method=RequestMethod.PUT)
	public ResponseInfo removeProductsToTheSoppingCart(@PathVariable("productid") long productId, @PathVariable("quantity") long quantity) {
		ResponseInfo info = new ResponseInfo();
		Product product = ProductService.get(productId);
			shoppingCardService.removeProduct(product,quantity);
			info.setResponse('Y');
			return info;
	}
	
	
    @ResponseBody
	@RequestMapping(value = "/shopping/products")
	public List<Product> getProdcucts() {
		List<Product> products = shoppingCardService.getProduct();
		return products;
	}
    
    @ResponseBody
  	@RequestMapping(value = "/shopping/processtoCheckout")
  	public void checkout() {
    	// check if the user login in the system
    	
    	// IF NOT goto login page
        
    	//check if the user have payment card 
    	// IF NOT goto add payment card
    	
    	//select payment card
    	
    }
}
