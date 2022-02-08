package com.learning.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learning.entity.Login;
import com.learning.entity.Register;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.repo.LoginRepository;
import com.learning.repo.UserRepository;
import com.learning.service.LoginService;
import com.learning.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private LoginRepository loginRepo;
	@Autowired
	private LoginService loginService;

	@Override
	@Transactional(rollbackFor = AlreadyExistsException.class)
	public Register addUser(Register register) throws AlreadyExistsException {
		// TODO Auto-generated method stub
		if(userRepo.existsByEmail(register.getEmail())) {
			throw new AlreadyExistsException("This record already exists");
		}
		Register register2 = userRepo.save(register);
		if (register2!=null) {
			Login login = new Login(register2.getEmail(), register2.getPassword(), register2);
			if (loginRepo.existsByEmail(login.getEmail())) {
				throw new AlreadyExistsException("This record already exists");
			}
			Login result = loginService.addCredentials(login);
			if (result!=null)
				return register2;
			else
				return null;
		}
		else
			return null;
	}

	@Override
	public Optional<List<Register>> getAllUsers() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(userRepo.findAll());
	}

	@Override
	public Optional<Register> getUserById(int id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Register> optional = userRepo.findById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException("Sorry user with "+ id +" not found");
		}
		return optional;
	}

	@Override
	public Register updateUser(Register register, int id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if (userRepo.findById(id).isEmpty()) {
			throw new IdNotFoundException("Sorry user with "+ id +" not found");
		}
		return userRepo.save(register);
	}

	@Override
	@Transactional(rollbackFor = IdNotFoundException.class)
	public String deleteUser(int id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Register> optional = this.getUserById(id);
		if (optional.isEmpty())
			throw new IdNotFoundException("Sorry user with "+ id +" not found");
		else {
			loginService.deleteCredentials(optional.get().getEmail());
			userRepo.deleteById(id);
			return "Success";
		}
	}

}