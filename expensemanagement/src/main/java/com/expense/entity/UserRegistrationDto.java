package com.expense.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegistrationDto {
	@NotBlank(message="firstname required")
	private String firstname;
	@NotBlank(message="lastname required")
	private String lastname;
	@NotNull(message="email required")
	@Email(message="Enter a valid email")
	private String email;
	@NotNull(message="password required")
	@Size(min=5, message="password should be atleast five characters")
	private String password;
	public UserRegistrationDto() {
	}
	
	public UserRegistrationDto(String firstname, String lastname, String email, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
