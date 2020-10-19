package com.zup.nossobancodigital.config.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailFormatValidator implements 
 ConstraintValidator<EmailConstraint, String>{

	@Override
    public void initialize(EmailConstraint email) {
    }
 
	@Override
    public boolean isValid(String email, ConstraintValidatorContext cxt) {
		if(email == null) return false;
		
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
    }
}
