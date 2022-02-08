package com.learning.service;

import java.util.List;

import com.learning.entity.Register;

public interface UserService {
	public List<Register> getUsers();
	public Register getUserById(int id);
	public Register[] getAllUsers();
	public String deleteuserbyid(int id);
	public Register addUser(Register user);
}
