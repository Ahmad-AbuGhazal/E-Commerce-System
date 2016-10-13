package edu.mum.estore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.estore.domain.Customer;
import edu.mum.estore.domain.PaymentCard;
import edu.mum.estore.exception.PaymentNotValidException;
import edu.mum.estore.service.CustomerService;
import edu.mum.estore.service.PaymentCardService;

@RestController
public class CustomerController {
@Autowired 
CustomerService customerService;
@Autowired
PaymentCardService paymentCardService;


@ResponseBody
@RequestMapping(value="/customers/{id}")
public Customer getProfile(@PathVariable("id") long id){
	if(id<=0)
	return null;
	else 
		return customerService.get(id);
}


@RequestMapping(value="/customers/{id}/payments",method=RequestMethod.POST)
public void addPayment(@RequestParam("id") long id,@Valid@RequestBody PaymentCard card){
	Customer customer=customerService.get(id);
	card.setCustomer(customer);
	paymentCardService.save(card);
	
}


@RequestMapping(value="/customers/{id}/payments/{paymentId}",method=RequestMethod.GET)
public void removePayment(@PathVariable("id") long customerId,@PathVariable("paymentId") long paymentId){
	try
	{
	paymentCardService.remove(paymentId);
	}
	catch(Exception ex){
	throw new PaymentNotValidException("Payment Card Not Found");
	}
}

@RequestMapping(value="/customers/{id}/payments",method=RequestMethod.GET)
public @ResponseBody List<PaymentCard> getPayments(@PathVariable("id") long customerId){
	return paymentCardService.getAll(customerId);
}
}