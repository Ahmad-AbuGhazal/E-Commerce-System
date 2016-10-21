package edu.mum.estore.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.estore.domain.ResponseInfo;
import edu.mum.estore.domain.Vendor;
import edu.mum.estore.service.VendorService;

@RestController
public class VendorController {

	@Autowired
	private VendorService vendorService;
	
	@ResponseBody
	@ResponseStatus(value=HttpStatus.OK)
	@RequestMapping(value="/vendor/add/", method=RequestMethod.POST, consumes="application/json")
	public ResponseInfo addVendor(@RequestBody @Valid Vendor vendor, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			ResponseInfo response = new ResponseInfo();
			response.setResponse('N');
			return response;
		}
		return vendorService.addVendor(vendor);
	}
	
	@ResponseBody
	@ResponseStatus(value=HttpStatus.OK)
	@RequestMapping(value="/vendors/{vendorId}", method=RequestMethod.GET, produces="application/json")
	public Vendor getVendor(@PathVariable("vendorId") long vendorId) {
		return vendorService.searchVendor(vendorId);
	}
}
