package edu.mum.estore.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.estore.domain.Order;
import edu.mum.estore.domain.OrderDetails;
import edu.mum.estore.repository.OrderRepository;
import edu.mum.estore.service.OrderService;
@Transactional
@Service
public class OrderServiceImpl implements OrderService {
@Autowired
OrderRepository orderRepository;
	@Override
	public List<Order> getAll(long customerId) {
		return orderRepository.getAll(customerId);
	}
	@Override
	public List<OrderDetails> getOrderDetails(long orderId) {
		return orderRepository.getOrderDetails(orderId);
	}

}
