package com.learning.service;

import com.learning.entity.Role;
import com.learning.exception.IdNotFoundException;

public interface RoleService {
	
	public String addRole(Role role);
	public void deleteRole(int roleId) throws IdNotFoundException;

}
