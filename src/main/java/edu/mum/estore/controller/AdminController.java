package edu.mum.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.estore.domain.ResponseInfo;
import edu.mum.estore.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "/admin/operations/approve/customer/{customerId}", method = RequestMethod.GET)
	public @ResponseBody ResponseInfo approveCustomer(@PathVariable Long customerId){
		ResponseInfo responseInfo = new ResponseInfo();
		
		if(customerId >= 0){
			if(adminService.approveCustomer(customerId)){
				responseInfo.setResponse('Y');
			}else{
				responseInfo.setResponse('N');
			}
		}else{
			responseInfo.setResponse('N');
		}
		
		return responseInfo;
	}
	
	@RequestMapping(value = "/admin/operations/disapprove/customer/{customerId}", method = RequestMethod.GET)
	public @ResponseBody ResponseInfo disapproveCustomer(@PathVariable Long customerId){
		ResponseInfo responseInfo = new ResponseInfo();
		
		if(customerId >= 0){
			if(adminService.disapproveCustomer(customerId)){
				responseInfo.setResponse('Y');
			}else{
				responseInfo.setResponse('N');
			}
		}else{
			responseInfo.setResponse('N');
		}
		
		return responseInfo;
	}
	
	@RequestMapping(value = "/admin/operations/approve/product/{productId}", method = RequestMethod.GET)
	public @ResponseBody ResponseInfo approveProduct(@PathVariable Long productId){
		ResponseInfo responseInfo = new ResponseInfo();
		
		if(productId >= 0){
			if(adminService.approveProduct(productId)){
				responseInfo.setResponse('Y');
			}else{
				responseInfo.setResponse('N');
			}
		}else{
			responseInfo.setResponse('N');
		}
		
		return responseInfo;
	}
	
	@RequestMapping(value = "/admin/operations/disapprove/product/{productId}", method = RequestMethod.GET)
	public @ResponseBody ResponseInfo disapproveProduct(@PathVariable Long productId){
		ResponseInfo responseInfo = new ResponseInfo();
		
		if(productId >= 0){
			if(adminService.disapproveProduct(productId)){
				responseInfo.setResponse('Y');
			}else{
				responseInfo.setResponse('N');
			}
		}else{
			responseInfo.setResponse('N');
		}
		
		return responseInfo;
	}
	
	@RequestMapping(value = "/admin/operations/approve/vendor/{vendorId}", method = RequestMethod.GET)
	public @ResponseBody ResponseInfo approveVendor(@PathVariable Long vendorId){
		ResponseInfo responseInfo = new ResponseInfo();
		
		if(vendorId >= 0){
			if(adminService.approveVendor(vendorId)){
				responseInfo.setResponse('Y');
			}else{
				responseInfo.setResponse('N');
			}
		}else{
			responseInfo.setResponse('N');
		}
		
		return responseInfo;
	}
	
	@RequestMapping(value = "/admin/operations/disapprove/vendor/{vendorId}", method = RequestMethod.GET)
	public @ResponseBody ResponseInfo disapproveVendor(@PathVariable Long vendorId){
		ResponseInfo responseInfo = new ResponseInfo();
		
		if(vendorId >= 0){
			if(adminService.disapproveVendor(vendorId)){
				responseInfo.setResponse('Y');
			}else{
				responseInfo.setResponse('N');
			}
		}else{
			responseInfo.setResponse('N');
		}
		
		return responseInfo;
	}
}
