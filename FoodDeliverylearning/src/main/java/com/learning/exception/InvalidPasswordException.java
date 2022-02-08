package com.learning.exception;

import lombok.ToString;

@ToString(callSuper = true)
public class InvalidPasswordException extends Exception {

	public InvalidPasswordException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}