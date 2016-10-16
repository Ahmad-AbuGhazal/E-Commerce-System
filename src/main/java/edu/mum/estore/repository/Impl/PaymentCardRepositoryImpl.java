package edu.mum.estore.repository.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	@Override
	public PaymentCard get(long id) {
	return enitiyManager.find(PaymentCard.class, id);
		
	}
	@Override
	public void remove(long id) {
		PaymentCard card=enitiyManager.find(PaymentCard.class, id);
		enitiyManager.remove(card);
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PaymentCard> getAll(long customerId) {
	Query query=enitiyManager.createQuery("SELECT p from PaymentCard p where p.customer.id=:id");
    return(List<PaymentCard>)query.setParameter("id", customerId).getResultList();
	}
	@Override
	public PaymentCard getByCardNumber(String cardNumber) {
	Query query=enitiyManager.createQuery("SELECT p from PaymentCard p where p.cardNum=:cardNumber");
    PaymentCard card=null;
    try{
	card=(PaymentCard)query.setParameter("cardNumber", cardNumber).getSingleResult();
	}
    catch(Exception ex){
    	card=null;
    }
    return card;
}
}
