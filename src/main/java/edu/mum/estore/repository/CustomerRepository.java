package edu.mum.estore.repository;

import edu.mum.estore.domain.Customer;

public interface CustomerRepository {
 Customer get(long id);
}
