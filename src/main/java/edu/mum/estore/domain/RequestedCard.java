package edu.mum.estore.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Class for @RequestBody
 * @author Lin
 *
 */

@Entity
public class RequestedCard {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="cardType")
	private String cardType;
	
	@Column(name="cardHolder")
	private String cardHolder;

	@Column(name="cardNum")
	private String cardNum;

	@Column(name="securityCode")
	private String securityCode;

	@Column(name="expiration")
	private Date expiration;

	private float purchaseAmount;
	
	public RequestedCard() {}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
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

	public void setExpiration(Date date) {
		this.expiration = date;
	}

	public float getPurchaseAmount() {
		return purchaseAmount;
	}

	public void setPurchaseAmount(float purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

	@Override
	public String toString() {
		return "RequestedCard [cardType=" + cardType + ", cardHolder=" + cardHolder + ", cardNum=" + cardNum
				+ ", securityCode=" + securityCode + ", expiration=" + expiration + ", purchaseAmount=" + purchaseAmount
				+ "]";
	}
}
