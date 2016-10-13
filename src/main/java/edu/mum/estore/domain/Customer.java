package edu.mum.estore.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
    @Column(name="CUST_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    long id;
    
    @NotEmpty
    @Size(min=3,max=25,message="{User.firstName.empty}")
    @Column(name = "FIRSTNAME", nullable = false)
    private String firstName;
    
    @NotEmpty
    @Size(min=3,max=25,message="{User.lastName.empty}")
    @Column(name = "LASTNAME", nullable = false)
    private String lastName;
    
    @Email
    @Column(name = "EMAIL", nullable = false)
    private String email;
    
    @Valid
    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Address address;

    @Valid
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="USERCREDENTIAL")
	UserCredantials userCredentials;
	
	@JsonIgnore
	@Transient
	private ShoppingCard card=new ShoppingCard();
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="customer")
	List<Order> orders=new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="customer")
	List<PaymentCard> paymentCards=new ArrayList<>();
	public long getId() {
		return id;
	}

	public List<PaymentCard> getPaymentCards() {
		return paymentCards;
	}

	public void setPaymentCards(List<PaymentCard> paymentCards) {
		this.paymentCards = paymentCards;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
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