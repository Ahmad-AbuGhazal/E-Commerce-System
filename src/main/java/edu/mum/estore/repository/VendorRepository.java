/**
 * 
 */
package edu.mum.estore.repository;

import java.util.List;

import edu.mum.estore.domain.Vendor;

/**
 * @author Tek
 * @date 10/7/2016
 *
 */
public interface VendorRepository {
	public void addVendor(Vendor vendor);
	public Vendor searchVendor(Long id);
	public List<Vendor> getVendors();
}
