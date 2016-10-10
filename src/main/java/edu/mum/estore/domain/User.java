package edu.mum.estore.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.Valid;

import org.hibernate.validator.constraints.Email;

public class User {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long id = null;
    @Version
    private int version = 0;
     @Column(name = "FIRSTNAME", nullable = false)
    private String firstName;
    
     @Column(name = "LASTNAME", nullable = false)
    private String lastName;
    @Email
    @Column(name = "EMAIL", nullable = false)
    private String email;
    
    
	@Valid
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="USERCREDENTIAL")
	UserCredantials userCredentials;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
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


	public UserCredantials getUserCredentials() {
		return userCredentials;
	}


	public void setUserCredentials(UserCredantials userCredentials) {
		this.userCredentials = userCredentials;
	}
}
