package com.registry.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registry.dao.RegistryDAO;
import com.registry.model.User;
import com.registry.service.RegistryService;

@Service
public class RegistryServiceImpl implements RegistryService {
	
	@Autowired
	RegistryDAO registryDAO;

	@Override
	public boolean validateUser(User user) {
		
		User record = registryDAO.validateUserDetails(user.getEmployeeId());
		
		return record.equals(user);
	}

}
