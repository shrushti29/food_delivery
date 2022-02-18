package com.learning.controlleradvice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;

@RestControllerAdvice
public class ExceptionAdvice {
	
	@ExceptionHandler(AlreadyExistsException.class)
	public ResponseEntity<?> alreadyExistsExceptionHandler(AlreadyExistsException e) {
		Map<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("message", e.getMessage());
		return ResponseEntity.badRequest().body(hashMap);
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<?> idNotFoundExceptionHandler(IdNotFoundException e) {
		Map<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("message", e.getMessage());
		return ResponseEntity.badRequest().body(hashMap);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exceptionHandler(Exception e) {
		Map<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("message", "Unknown Exception " + e.getMessage());
		return ResponseEntity.badRequest().body(hashMap);
	}

}
