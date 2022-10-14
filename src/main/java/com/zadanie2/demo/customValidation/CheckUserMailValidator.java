package com.zadanie2.demo.customValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckUserMailValidator implements ConstraintValidator<CheckUserMail, String> {

    private String endOfMail;

    @Override
    public void initialize(CheckUserMail constraintAnnotation) {
        endOfMail = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.endsWith(endOfMail);
    }
}
