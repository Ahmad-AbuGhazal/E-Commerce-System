package edu.mum.estore.service;

import edu.mum.estore.domain.Customer;

public interface CustomerService {
  Customer get(long id);
  void save(Customer customer);
}
