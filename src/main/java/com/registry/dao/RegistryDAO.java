package com.registry.dao;

import com.registry.model.User;

public interface RegistryDAO {
	
	public User validateUserDetails(int employeeId);

}
