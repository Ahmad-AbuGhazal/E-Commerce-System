package edu.mum.estore.domain;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "CREDENTIALS")
public class UserCredantials {

	@Id
	@NotEmpty(message = "{UserCredintial.username.empty}")
	@Size(min = 5, max = 50)
	@Column(nullable = false, unique = true, length = 127)
	String username;
	@NotEmpty(message = "{UserCredintial.password.empty}")
	@Size(min = 6)
	String password;
	@NotEmpty(message = "{UserCredintial.verifyPassword.empty}")
	@Size(min = 6)
	String verifyPassword;

	Boolean enabled;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="username")
	List<Authority> autharities = new ArrayList<Authority>();

	public List<Authority> getAutharities() {
		return autharities;
	}

	public void setAutharities(List<Authority> autharities) {
		this.autharities = autharities;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

}