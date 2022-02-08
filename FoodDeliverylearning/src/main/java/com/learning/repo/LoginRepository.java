package com.learning.repo;

//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import com.learning.entity.Login;
//
//import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;
//
//
//@Repository
//
//public interface LoginRepository extends JpaRepository<Login, Integer> {
//	
//
//	Boolean existsByEmail(String email);
//	Optional<Login> findByEmail(String email);
//	void deleteByEmail(String email);
//}

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
	

	Boolean existsByEmail(String email);

	Optional<Login> findByEmail(String email);

	void deleteByEmail(String email);
}