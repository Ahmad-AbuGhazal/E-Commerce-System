package edu.mum.estore.service;

import java.util.List;

import edu.mum.estore.domain.Vendor;

public interface AdminService {
	boolean approveCustomer(long customerId);
	boolean disapproveCustomer(long customerId);
	boolean approveProduct(long productId);
	boolean disapproveProduct(long productId);
	boolean approveVendor(long vendorId);
	boolean disapproveVendor(long vendorId);
	List<Vendor> viewVendors();
}
