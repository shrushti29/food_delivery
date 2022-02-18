package com.learning.service;

import java.util.List;
import java.util.Optional;

import com.learning.entity.Register;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;

public interface UserService {
	
	public Register addUser(Register user) throws AlreadyExistsException;
	public Optional<List<Register>> getAllUsers();
	public Optional<Register> getUserById(Long id) throws IdNotFoundException;
	public Register updateUser(Register user, Long id) throws IdNotFoundException;
	public String deleteUser(Long id) throws IdNotFoundException;

}