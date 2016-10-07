package edu.mum.estore.service;

import java.util.List;

import edu.mum.estore.domain.Vendor;

public interface VendorService {
	public void addVendor(Vendor vendor);
	public Vendor searchVendor(Long id);
	public List<Vendor> getVendors();
}
