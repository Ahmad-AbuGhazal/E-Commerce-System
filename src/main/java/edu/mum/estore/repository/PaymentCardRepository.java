package edu.mum.estore.repository;

import java.util.List;

import edu.mum.estore.domain.PaymentCard;

public interface PaymentCardRepository {
void save(PaymentCard card);
List<PaymentCard> getAll(long customerId);
PaymentCard get(long id);
void remove(long id);
}
