package edu.mum.estore.repository.Impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import edu.mum.estore.domain.PaymentCard;
import edu.mum.estore.repository.PaymentCardRepository;
@Repository
public class PaymentCardRepositoryImpl implements PaymentCardRepository {
    @PersistenceContext
    EntityManager enitiyManager;
	@Override
	public void save(PaymentCard card) {
		enitiyManager.persist(card);
	}

}
