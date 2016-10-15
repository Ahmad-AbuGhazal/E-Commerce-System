package edu.mum.estore.service;

import java.util.List;

import edu.mum.estore.domain.Order;
import edu.mum.estore.domain.OrderDetails;

public interface OrderService {
List<Order> getAll(long customerId);

List<OrderDetails> getOrderDetails(long orderId);
}
