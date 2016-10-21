package edu.mum.estore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Address {

	@Id
	@GeneratedValue
	private long id;

	@NotNull
	@NotEmpty
	@Length(min=8, max=30)
	private String street;
	@NotNull
	@NotEmpty
	@Length(min=3, max=30)
	private String city;
	@NotNull
	@NotEmpty
	@Length(min=2, max=30)
	private String state;
	
	@NotNull
	@NotEmpty
	@Length(min=5, max=5)
	private String zipcode;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
