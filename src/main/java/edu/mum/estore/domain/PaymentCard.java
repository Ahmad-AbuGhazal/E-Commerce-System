package edu.mum.estore.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class PaymentCard {
		
		public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public float getMaxCredit() {
		return maxCredit;
	}

	public void setMaxCredit(float maxCredit) {
		this.maxCredit = maxCredit;
	}

	public float getAvailableCredit() {
		return availableCredit;
	}

	public void setAvailableCredit(float availableCredit) {
		this.availableCredit = availableCredit;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

		@Id
		@GeneratedValue
		private long id;
		
		private String cardHolder;
		
		private String cardNum;
		
		private String securityCode;
		
		private Date expiration;
		
		private float maxCredit;
		
		private float availableCredit;
		
		private boolean status;
	    @ManyToOne
	    Customer customer;
		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
}