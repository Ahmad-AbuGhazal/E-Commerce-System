package edu.mum.estore.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import edu.mum.estore.domain.Vendor;

public interface VendorService {
	public String addVendor(Vendor vendor);
	public Vendor searchVendor(Long id);
	public List<Vendor> getVendors();
}
