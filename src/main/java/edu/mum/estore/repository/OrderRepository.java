package edu.mum.estore.repository;

import java.util.List;

import edu.mum.estore.domain.Order;
import edu.mum.estore.domain.OrderDetails;

public interface OrderRepository {
	List<Order> getAll(long customerId);

	List<OrderDetails> getOrderDetails(long orderId);
}
