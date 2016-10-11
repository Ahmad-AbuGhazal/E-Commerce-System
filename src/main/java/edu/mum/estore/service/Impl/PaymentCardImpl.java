package edu.mum.estore.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.estore.domain.PaymentCard;
import edu.mum.estore.repository.PaymentCardRepository;
import edu.mum.estore.service.PaymentCardService;
@Service
@Transactional
public class PaymentCardImpl implements PaymentCardService {
 @Autowired
 PaymentCardRepository paymentCardRepository;
	@Override
	public void save(PaymentCard card) {
		paymentCardRepository.save(card);
		
	}

}
