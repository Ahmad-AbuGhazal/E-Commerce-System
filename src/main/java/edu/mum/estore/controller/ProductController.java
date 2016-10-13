package edu.mum.estore.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.estore.domain.Product;
import edu.mum.estore.domain.ResponseInfo;
import edu.mum.estore.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;

	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/products", method = RequestMethod.GET,consumes="application/json")
	public List<Product> searchProduct(@RequestParam("productName") String productName,
			@RequestParam("productCategory") String categoryName) {
		return productService.searchProduct(productName, categoryName);

	}
	
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET,consumes="application/json")
	public Product searchProductById(@PathVariable("id") long productId) {
		Product product=productService.get(productId);
		return product;
	}
	
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/products/{id}/names", method = RequestMethod.GET,consumes="application/json")
	public List<Product> searchSimillerProductById(@PathVariable("id") long productId) {
		Product product=productService.get(productId);
		List<Product> products=productService.searchProduct(product.getProductName(), product.getCategory().getCategoryName());
		products=products.stream().limit(4).collect(Collectors.toList());
		return products;
	}
	

	@ResponseBody
	@RequestMapping(value = "/products/add", method = RequestMethod.POST,consumes="application/json")
	public ResponseInfo addProduct(@RequestBody @Valid Product product, BindingResult result) {

		ResponseInfo info = new ResponseInfo();
		if (result.hasErrors()) {
			info.setResponse('N');

		}
		productService.addProduct(product);
		info.setResponse('Y');
		return info;

	}

	@ResponseBody
	@RequestMapping(value = "/vendors/{vendor_sn}/products/{productName}", method = RequestMethod.GET,consumes="application/json")
	public ResponseInfo verifyProduct(@PathVariable("vendor_sn") long vendorId,@PathVariable("productName") String productName) {
		ResponseInfo info = new ResponseInfo();
		Product product = productService.getProductByName(vendorId,productName);
		if (product == null) {
			info.setResponse('Y');
		} else {
			info.setResponse('N');
		}
		return info;
	}

}
