package com.javadoterr.api.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.javadoterr.api.utils.ConstantUtils;

@Entity
public class Address extends AbstractPersistable<Long> {

	private transient Long id;
	@NotNull
	@Size(min = 3, max = 15, message = "Please enter between {min}-{max} characters")
	@Pattern(regexp = ConstantUtils.CHAR_PATTERN, message = "Please enter only characters")
	private String city;
	@NotNull
	@Size(min = 3, max = 15, message = "Please enter between {min}-{max} characters")
	@Pattern(regexp = ConstantUtils.CHAR_PATTERN, message = "Please enter only characters")
	private String state;
	@NotNull
	@Size(min = 3, max = 15, message = "Please enter between {min}-{max} characters")
	@Pattern(regexp = ConstantUtils.CHAR_PATTERN, message = "Please enter only characters")
	private String country;
	@NotNull
	@Size(min = 10, max = 100, message = "Please enter between {min}-{max} characters")
	private String addressLine;
	@NotNull
	@Size(min = 6, max = 6, message = "Please enter alteast {min} digits")
	@Pattern(regexp = ConstantUtils.CODE_PATTERN, message = "Please enter only digits")
	private String pinCode;
	
	
	//we will create one transient filed for userId
	private transient Long userId;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Address() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public String getAddressLine() {
		return addressLine;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	
	public String getPinCode() {
		return pinCode;
	}
	
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	

}
