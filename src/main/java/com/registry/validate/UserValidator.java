package com.registry.validate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.registry.model.User;

@Component
public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		
		User user = (User) object;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeId", "error.employeeId");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.firstName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.lastName");
		
		
	}

}
