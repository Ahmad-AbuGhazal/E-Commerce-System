package edu.mum.estore.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.estore.domain.Customer;
import edu.mum.estore.domain.Product;
import edu.mum.estore.domain.Vendor;
import edu.mum.estore.exception.CustomerNotFoundException;
import edu.mum.estore.exception.ProductNotFoundException;
import edu.mum.estore.exception.VendorNotFoundException;
import edu.mum.estore.repository.CustomerRepository;
import edu.mum.estore.repository.ProductRepository;
import edu.mum.estore.repository.VendorRepository;
import edu.mum.estore.service.AdminService;


@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private VendorRepository vendorRepository;

	@Override
	public boolean approveCustomer(long customerId) {
		Customer customer = customerRepository.get(customerId);

		if (customer != null) {
			customer.setApprove(true);
			customerRepository.save(customer);
			return true;
		} else {
			throw new CustomerNotFoundException("Customer by this id is not found!");
		}
	}

	@Override
	public boolean disapproveCustomer(long customerId) {
		Customer customer = customerRepository.get(customerId);

		if (customer != null) {
			customer.setApprove(false);
			customerRepository.save(customer);
			return true;
		} else {
			throw new CustomerNotFoundException("Customer by this id is not found!");
		}
	}

	@Override
	public boolean approveProduct(long productId) {
		Product product = productRepository.get(productId);

		if (product != null) {
			product.setApprove(true);
			productRepository.addProduct(product);
			return true;
		} else {
			throw new ProductNotFoundException("Product by this id is not found!");
		}
	}

	@Override
	public boolean disapproveProduct(long productId) {
		Product product = productRepository.get(productId);

		if (product != null) {
			product.setApprove(false);
			productRepository.addProduct(product);
			return true;
		} else {
			throw new ProductNotFoundException("Product by this id is not found!");
		}
	}

	@Override
	public boolean approveVendor(long vendorId) {
		Vendor vendor = vendorRepository.searchVendor(vendorId);

		if (vendor != null) {
			vendor.setApprove(true);
			vendorRepository.addVendor(vendor);
			return true;
		} else {
			throw new VendorNotFoundException("Vendor by this id is not found!");
		}
	}

	@Override
	public boolean disapproveVendor(long vendorId) {
		Vendor vendor = vendorRepository.searchVendor(vendorId);

		if (vendor != null) {
			vendor.setApprove(false);
			vendorRepository.addVendor(vendor);
			return true;
		} else {
			throw new VendorNotFoundException("Vendor by this id is not found!");
		}
	}

	@Override
	public List<Vendor> viewVendors() {
		return vendorRepository.getVendors();
	}
}
