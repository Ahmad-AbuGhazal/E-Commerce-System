package edu.mum.estore.controller;

import java.util.ArrayList;
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

import edu.mum.estore.domain.JsonResponse;
import edu.mum.estore.domain.Product;
import edu.mum.estore.domain.ResponseInfo;
import edu.mum.estore.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;

	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/products", method = RequestMethod.GET, produces="application/json")
	public JsonResponse<Product> searchProduct(@RequestParam("productName") String productName,
			@RequestParam("productCategory") String categoryName) {
		JsonResponse<Product> response = new JsonResponse<Product>();
		response.setData(productService.searchProduct(productName, categoryName));
		return response;

	}
	
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET,produces="application/json")
	public JsonResponse<Product> searchProductById(@PathVariable("id") long productId) {
		JsonResponse<Product> response = new JsonResponse<Product>();
		List<Product> list = new ArrayList<>();
		Product product=productService.get(productId);
		list.add(product);
		response.setData(list);
		return response;
	}
	
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/products/{id}/names", method = RequestMethod.GET,produces="application/json")
	public JsonResponse<Product> searchSimillerProductById(@PathVariable("id") long productId) {
		JsonResponse<Product> response = new JsonResponse<Product>();
		Product product=productService.get(productId);
		List<Product> products=productService.searchProduct(product.getProductName().substring(0, 1), product.getCategory().getCategoryName());
		products=products.stream().limit(4).collect(Collectors.toList());
		response.setData(products);
		return response;
	}
	

	@ResponseBody
	@RequestMapping(value = "/products/add", method = RequestMethod.POST,consumes="application/json")
	public ResponseInfo addProduct(@RequestBody @Valid Product product, BindingResult result) {

		ResponseInfo info = new ResponseInfo();
		if (result.hasErrors()) {
			product.setApprove(false);
			info.setResponse('N');
		}
		
		product.setApprove(true);
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
	
	
	@RequestMapping(value = "/vendors/{vendor_sn}/products", method = RequestMethod.GET)
	public @ResponseBody List<Product> viewProducts(@PathVariable("vendor_sn") long vendorId){
	return productService.findProductsByVendorId(vendorId);
	}


}
