package com.learning.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginRequest {
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String password;

	public Object getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

}