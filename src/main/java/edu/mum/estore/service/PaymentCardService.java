package edu.mum.estore.service;

import java.util.List;

import edu.mum.estore.domain.PaymentCard;

public interface PaymentCardService {
 void save(PaymentCard card);
 PaymentCard get(long id);
 List<PaymentCard> getAll(long customerId);
 void remove(long id);
}
