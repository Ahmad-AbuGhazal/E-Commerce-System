package edu.mum.estore.repository.Impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import edu.mum.estore.domain.Customer;
import edu.mum.estore.repository.CustomerRepository;
@Repository
public class CusomerRepositioryImpl implements CustomerRepository {
@PersistenceContext
EntityManager enityManager;
	@Override
	public Customer get(long id) {
		Customer customer= enityManager.find(Customer.class, id);
		return customer;
	}

}
