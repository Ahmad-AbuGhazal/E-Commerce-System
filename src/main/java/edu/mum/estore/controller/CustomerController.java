package edu.mum.estore.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.estore.domain.Customer;
import edu.mum.estore.domain.PaymentCard;
import edu.mum.estore.service.CustomerService;
import edu.mum.estore.service.PaymentCardService;

@RestController
public class CustomerController {
@Autowired 
CustomerService customerService;
@Autowired
PaymentCardService paymentCardService;
@ResponseBody
@RequestMapping(value="/customer/{id}")
public Customer getProfile(@PathVariable("id") long id){
	if(id<=0)
	return null;
	else 
		return customerService.get(id);
}

@RequestMapping(value="/customer/{id}",method=RequestMethod.POST)
public void addPayment(@RequestParam("id") long id,@Valid PaymentCard card){
	paymentCardService.save(card);
}
}
