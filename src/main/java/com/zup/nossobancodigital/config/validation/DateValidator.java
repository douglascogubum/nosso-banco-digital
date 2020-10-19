package com.zup.nossobancodigital.config.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateValidator implements 
 ConstraintValidator<DateFormatConstraint, String>{

 @Override
    public void initialize(DateFormatConstraint dateFormat) {
    }
 
    @Override
    public boolean isValid(String birthDateField, ConstraintValidatorContext cxt) {
    	try {
    		if(birthDateField == null) 
    			return false;		
    			
    		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    		sdf.parse(birthDateField);
    		
    		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");    		
    		LocalDate formattedBirthDate = LocalDate.parse(birthDateField, formatter);
    		LocalDate currentDate = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC).toLocalDate();
    		Period period = Period.between(formattedBirthDate, currentDate);
    			
    		return 	period.getYears() > 18 &&
    				!(period.getDays() < 0);
    				
    	} catch(DateTimeException|ParseException e) {
    		return false;
    	}
    }
}
