package com.learning.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.Register;

import com.learning.repo.UserRepository;
import com.learning.service.UserService;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

public class UserServiceImpl implements UserService {

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository repository;
//	public List<Register> getUsers() {
//		return repository.findAll();
//		
//	}
//	
////	public List<Register> getuserbyid(int id) {
//public Register getUserById(int id)
//	{		return repository.findById(id).orElse(null);
//	}
//	public Register[] getAllUsers() {
//		// TODO Auto-generated method stub
//		List<Register> list = repository.findAll();
//		Register[] array = new Register[list.size()];
//		return list.toArray(array);
//	}
//	
//	
//	//public User updatebook()
//	public String deleteuserbyid(int id) {
//		 repository.deleteById(id);
//		 if (repository==null) {
//			 return "User Deleted Successfully";
//		 }
//		 
//		 return "sorry user with "+id+"not found";
//		
//	}
//	public Register addUser(Register user) {
//		return repository.save(user);
//	}
//}

public List<Register> getUsers() {
	// TODO Auto-generated method stub
	return repository.findAll();
}

public Register getUserById(int id) {
	// TODO Auto-generated method stub
	return repository.findById(id).orElse(null);
}

public Register[] getAllUsers() {
	// TODO Auto-generated method stub
	List<Register> list = repository.findAll();
	Register[] array = new Register[list.size()];
	return list.toArray(array);
}

public String deleteuserbyid(int id) {
	// TODO Auto-generated method stub
	 repository.deleteById(id);
 if (repository==null) {
		 return "User Deleted Successfully";
 }
return null;
}

public Register addUser(Register user) {
	// TODO Auto-generated method stub
	return repository.save(user);
}

}

@Override
public List<Register> getUsers() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Register getUserById(int id) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Register[] getAllUsers() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String deleteuserbyid(int id) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Register addUser(Register user) {
	// TODO Auto-generated method stub
	return null;
}}

