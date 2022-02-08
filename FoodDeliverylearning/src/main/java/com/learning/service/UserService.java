package com.learning.service;


import java.util.List;
import java.util.Optional;

import com.learning.entity.Register;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;

public interface UserService {
	
	public Register addUser(Register register) throws AlreadyExistsException;
	public Optional<List<Register>> getAllUsers();
	public Optional<Register> getUserById(int id) throws IdNotFoundException;
	public Register updateUser(Register register, int id) throws IdNotFoundException;
	public String deleteUser(int id) throws IdNotFoundException;

}