package com.learning.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learning.entity.Register;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.repository.UserRepository;
import com.learning.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	@Transactional(rollbackFor = AlreadyExistsException.class)
	public Register addUser(Register register) throws AlreadyExistsException {
		// TODO Auto-generated method stub
		if(userRepo.existsByEmail(register.getEmail())) {
			throw new AlreadyExistsException("This record already exists");
		}
		return userRepo.save(register);
	}

	@Override
	public Optional<List<Register>> getAllUsers() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(userRepo.findAll());
	}

	@Override
	public Optional<Register> getUserById(Long id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Register> optional = userRepo.findById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException("Sorry user with "+ id +" not found");
		}
		return optional;
	}

	@Override
	public Register updateUser(Register register, Long id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if (userRepo.findById(id).isEmpty()) {
			throw new IdNotFoundException("Sorry user with "+ id +" not found");
		}
		return userRepo.save(register);
	}

	@Override
	@Transactional(rollbackFor = IdNotFoundException.class)
	public String deleteUser(Long id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Register> optional = this.getUserById(id);
		if (optional.isEmpty())
			throw new IdNotFoundException("Sorry user with "+ id +" not found");
		else {
			userRepo.deleteById(id);
			return "Success";
		}
	}

}