package com.learning.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.Register;
import com.learning.service.UserService;
@Controller
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@GetMapping("/users")
	public List<Register> getAllUsers() {
		return userservice.getUsers();
	}
	
	@GetMapping("/users/{id}")
	public Optional<Register> getUserByid(@PathVariable int id) {
		return Optional.ofNullable(userservice.getUserById(id));
	}

	@PutMapping("/users/{id1}")
	public Optional<Register> updateUserByid(@PathVariable int id1) {
		return Optional.ofNullable(userservice.getUserById(id1));
	}
	
	@DeleteMapping("/users/{id2}")
	public String DeleteUserByid(@PathVariable int id2) {
		return userservice.deleteuserbyid(id2);
	}
	
	@PostMapping("/register")
	public Register postuser(@RequestBody Register register){
		
		return userservice.addUser(register);
		
	}



}
