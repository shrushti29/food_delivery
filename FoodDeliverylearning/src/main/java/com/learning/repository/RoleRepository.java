package com.learning.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.entity.EROLE;
import com.learning.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	Optional<Role> findByRoleName(EROLE roleName);

}
