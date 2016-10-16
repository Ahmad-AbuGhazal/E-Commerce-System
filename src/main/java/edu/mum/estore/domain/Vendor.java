 	package edu.mum.estore.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author Tek
 * @Date 10/6/2016
 *
 */

@Entity
@Table(name="VENDOR")
public class Vendor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="VENDOR_SN")
	private long vendor_sn;
	
	@Column(name="VENDOR_ID")
	private String vendor_id;
	
	@Column(name="VENDOR_NAME")
	private String vendor_name;
	
	@Column(name="OWNER_NAME")
	private String owner_name;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;
	
	private boolean approve;
	
	public boolean isApprove() {
		return approve;
	}

	public void setApprove(boolean approve) {
		this.approve = approve;
	}

	@OneToOne(cascade=CascadeType.ALL)
	private RequestedCard requestedCard;
	
	public Vendor() {}

	public long getVendor_sn() {
		return vendor_sn;
	}

	public void setVendor_sn(long vendor_sn) {
		this.vendor_sn = vendor_sn;
	}

	public String getVendor_id() {
		return vendor_id;
	}

	public void setVendor_id(String vendor_id) {
		this.vendor_id = vendor_id;
	}

	public String getVendor_name() {
		return vendor_name;
	}

	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public RequestedCard getRequestedCard() {
		return requestedCard;
	}

	public void setRequestedCard(RequestedCard requestedCard) {
		this.requestedCard = requestedCard;
	}

}
