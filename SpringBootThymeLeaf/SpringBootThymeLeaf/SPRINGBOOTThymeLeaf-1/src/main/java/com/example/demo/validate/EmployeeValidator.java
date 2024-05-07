package com.example.demo.validate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.demo.bean.Employee;

import java.util.regex.Pattern;

@Component
public class EmployeeValidator implements Validator {
	
	private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@gmail\\.com$";
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

	 @Override
	    public boolean supports(Class<?> clazz) {
	        return Employee.class.equals(clazz);
	    }

	    @Override
	    public void validate(Object target, Errors errors) {
	        Employee employee = (Employee) target;

	        if (employee.getEmpName() == null || employee.getEmpName().isEmpty()) {
	            errors.rejectValue("name", "required", "Name is required");
	        }

	        if (employee.getMail() == null || employee.getMail().isEmpty()) {
	            errors.rejectValue("email", "required", "Email is required");
	        } else if (!isValidEmail(employee.getMail())) {
	            errors.rejectValue("email", "invalid", "Invalid email format");
	        }
	    }

	    private boolean isValidEmail(String email) {
	    	return pattern.matcher(email).matches();
	    }

}
