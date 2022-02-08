package com.learning.service.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.Login;
import com.learning.exception.IdNotFoundException;
import com.learning.repo.LoginRepository;
import com.learning.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginRepository loginRepo;

	@Override
	public Login addCredentials(Login login) {
		// TODO Auto-generated method stub
		return loginRepo.save(login);
	}

	@Override
	public String deleteCredentials(String email) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Login> optional = loginRepo.findByEmail(email);
		if (optional.isEmpty())
			throw new IdNotFoundException("Record not found");
		else {
			loginRepo.deleteByEmail(email);
			return "Success";
		}
	}
	
	@Override
	public Login updateCredentials(Login login, String email) throws IdNotFoundException {
		if (loginRepo.findByEmail(email).isEmpty()) {
			throw new IdNotFoundException("Record not found");
		}
		return loginRepo.save(login);
	}

	@Override
	public String validateCredentials(Login login) {
		// TODO Auto-generated method stub
		Optional<Login> optional = loginRepo.findByEmail(login.getEmail());
		if (optional.isEmpty())
			return "Fail";
		if (optional.get().getPassword().equals(login.getPassword()))
			return "Success";
		return "Fail";
	}

}