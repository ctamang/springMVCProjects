package com.practice.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidFieldConstraintValidator implements ConstraintValidator<ValidField, String>{

	public String field;
	
	@Override
	public void initialize(ValidField theValidField) {
		field = theValidField.value();
	}
	
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
		
		boolean result;
		
		if(theCode!=null) {
			result = theCode.startsWith("CHAN");
		}
		else {
			result = false;
		}
		
		return result;
	}

}
