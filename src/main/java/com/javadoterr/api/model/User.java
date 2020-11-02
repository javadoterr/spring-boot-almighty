package com.javadoterr.api.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.javadoterr.api.utils.ConstantUtils;
import com.javadoterr.api.validator.Validate;

@Entity
public class User extends AbstractPersistable<Long> {

	private transient Long id;
	
	@NotNull
	@Validate(min = 6, max = 6,regexp = ConstantUtils.ID_PATTERN ,message = "Please enter between {min}-{max} characters and digits")
	private String userId;
	
	@NotNull
	@Validate(min = 5, max = 30,regexp = ConstantUtils.CHAR_PATTERN ,message = "Please enter between {min}-{max} characters and no digits")
	private String fullName;
	
	@NotNull
	private String userName;
	@NotNull
	private String password;
	
	@NotNull
	@Validate(min = 10, max = 50,regexp = ConstantUtils.EMAIL_PATTERN ,message = "Please enter between {min}-{max} characters and valid email")
	private String email;
	
	@NotNull
	@Validate(min = 10, max = 10,regexp = ConstantUtils.MOBILE_PATTERN ,message = "Please enter alteast {min} digits and no characters")
	private String mobile;
	
	private transient Long roleId;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

	@OneToMany(targetEntity = Address.class, mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Address> addresses;

	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
