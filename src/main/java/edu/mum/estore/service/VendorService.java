package edu.mum.estore.service;

import java.util.List;

import edu.mum.estore.domain.ResponseInfo;
import edu.mum.estore.domain.Vendor;

public interface VendorService {
	public ResponseInfo addVendor(Vendor vendor);
	public Vendor searchVendor(Long id);
	public List<Vendor> getVendors();
}
