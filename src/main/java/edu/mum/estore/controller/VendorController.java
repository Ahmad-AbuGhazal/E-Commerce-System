package edu.mum.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	public ResponseInfo addVendor(@RequestBody Vendor vendor) {
		System.out.println(vendor.getAsString());
		return vendorService.addVendor(vendor);
	}
}
