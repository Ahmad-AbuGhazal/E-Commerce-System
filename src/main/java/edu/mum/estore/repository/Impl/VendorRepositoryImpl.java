package edu.mum.estore.repository.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.estore.domain.Vendor;
import edu.mum.estore.repository.VendorRepository;

@Repository
public class VendorRepositoryImpl implements VendorRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void addVendor(Vendor vendor) {
		entityManager.persist(vendor);
	}
	
	@Override
	public Vendor searchVendor(Long id) {
		return entityManager.find(Vendor.class, id);
	}
	
	@Override
	public List<Vendor> getVendors() {
		return null;
	}
}
