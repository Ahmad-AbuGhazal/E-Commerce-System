package edu.mum.estore.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import edu.mum.estore.config.PaymentConfig;
import edu.mum.estore.domain.PaymentCard;
import edu.mum.estore.domain.RequestedCard;
import edu.mum.estore.domain.ResponseInfo;
import edu.mum.estore.exception.PaymentNotValidException;
import edu.mum.estore.repository.PaymentCardRepository;
import edu.mum.estore.rest.RemoteApi;
import edu.mum.estore.service.PaymentCardService;

@Service
@Transactional
public class PaymentCardImpl implements PaymentCardService {

	@Autowired
	PaymentCardRepository paymentCardRepository;

	@Autowired
	RemoteApi remoteApi;

	@Override
	public void save(PaymentCard card) {
		System.out.println("inside the save Payment port 8085");
		RestTemplate restTemplate = remoteApi.getRestTemplate();

		// prepare the Request Card
		RequestedCard cardRequest = new RequestedCard();

		cardRequest.setCardHolder(card.getCardHolder());
		cardRequest.setCardNum(card.getCardNum());
		cardRequest.setExpiration(card.getExpiration());
		cardRequest.setSecurityCode(card.getSecurityCode());
		System.out.println("call veirfy Payment port 8087");
		// call the external System : Payment Module
		HttpEntity<RequestedCard> httpEntity = new HttpEntity<RequestedCard>(cardRequest, remoteApi.getHttpHeaders());
		ResponseEntity<ResponseInfo> response = restTemplate.exchange(PaymentConfig.PAYMENT_VERIFY_URL, HttpMethod.POST,
				httpEntity, ResponseInfo.class);
		
		System.out.println(response.getBody().getResponse());
		if (response != null && response.getBody().getResponse()=='Y') {
		    System.out.println(card.getCardNum());
			PaymentCard storedCard=paymentCardRepository.getByCardNumber(card.getCardNum());
			System.out.println(storedCard);
			if(storedCard==null){
			paymentCardRepository.save(card);
			}
			else{
				throw new PaymentNotValidException("Payment already Inserted");
			}
		} else {
			throw new PaymentNotValidException("Payment Not Valid");
		}
	}

	@Override
	public void remove(long id) {
		paymentCardRepository.remove(id);

	}

	@Override
	public PaymentCard get(long id) {
		return paymentCardRepository.get(id);
	}

	@Override
	public List<PaymentCard> getAll(long customerId) {
		return paymentCardRepository.getAll(customerId);
	}
}
