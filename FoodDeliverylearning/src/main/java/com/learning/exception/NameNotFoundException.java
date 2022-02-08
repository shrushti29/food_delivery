package com.learning.exception;

import lombok.ToString;

@ToString(callSuper = true)
public class NameNotFoundException extends Exception {

	public NameNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}