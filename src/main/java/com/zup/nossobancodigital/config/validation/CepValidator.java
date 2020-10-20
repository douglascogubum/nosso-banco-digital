package com.zup.nossobancodigital.config.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CepValidator implements 
 ConstraintValidator<CepConstraint, String>{

	@Override
    public void initialize(CepConstraint cep) {
    }
 
	@Override
    public boolean isValid(String cep, ConstraintValidatorContext cxt) {
		
		if(cep == null || cep.length() != 8) return false;
		 
		String regex = "[0-9]{5}-[0-9]{3}"; 
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(cep);
		return matcher.matches(); 
    }
}
