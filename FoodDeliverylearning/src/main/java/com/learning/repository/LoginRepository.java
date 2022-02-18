package com.learning.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
	
//	Checking the email exists in the login table
	Boolean existsByEmail(String email);
//	Retrieving user by email
	Optional<Login> findByEmail(String email);
//	Deleting user by email
	void deleteByEmail(String email);
}
