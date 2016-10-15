package edu.mum.estore.repository.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.estore.domain.Order;
import edu.mum.estore.domain.OrderDetails;
import edu.mum.estore.repository.OrderRepository;
@Repository
public class OrderRepositoryImpl implements OrderRepository{
@PersistenceContext
EntityManager entityManager;
	@Override
	public List<Order> getAll(long customerId) {
		Query query=entityManager.createQuery("SELECT o from Order o WHERE o.customer.id=:customerId");
		return (List<Order>)query.setParameter("customerId", customerId).getResultList();
	}
	@Override
	public List<OrderDetails> getOrderDetails(long orderId) {
		Query query=entityManager.createQuery("SELECT o from OrderDetails o WHERE o.order.id=:orderId");
		return (List<OrderDetails>)query.setParameter("orderId", orderId).getResultList();
	
	}

}
