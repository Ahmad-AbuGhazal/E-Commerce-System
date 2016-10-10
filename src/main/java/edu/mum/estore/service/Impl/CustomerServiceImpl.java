package edu.mum.estore.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.estore.domain.Customer;
import edu.mum.estore.repository.CustomerRepository;
import edu.mum.estore.service.CustomerService;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
  @Autowired
  CustomerRepository customerRepository;
	@Override
	public Customer get(long id) {
		
		return customerRepository.get(id);
	}

}
