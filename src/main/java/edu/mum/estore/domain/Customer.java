package edu.mum.estore.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    long id;
    
    @NotEmpty(message="{User.firstName.empty}")
    @Size(min=3,max=25,message="{User.firstName.empty}")
    @Column(name = "FIRSTNAME", nullable = false)
    private String firstName;
    
    @NotEmpty(message="{User.lastName.empty}")
    @Size(min=3,max=25,message="{User.lastName.empty}")
    @Column(name = "LASTNAME", nullable = false)
    private String lastName;
    
    @Email(message="{User.email}")
    @Column(name = "EMAIL", nullable = false)
    private String email;
    
    @Valid
    @OneToOne
	private Address address;

    @Valid
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="USERCREDENTIAL")
	UserCredantials userCredentials;
	
	@JsonIgnore
	@Transient
	private ShoppingCard card=new ShoppingCard();
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public UserCredantials getUserCredentials() {
		return userCredentials;
	}

	public void setUserCredentials(UserCredantials userCredentials) {
		this.userCredentials = userCredentials;
	}

	public ShoppingCard getCard() {
		return card;
	}

	public void setCard(ShoppingCard card) {
		this.card = card;
	}

	
}
