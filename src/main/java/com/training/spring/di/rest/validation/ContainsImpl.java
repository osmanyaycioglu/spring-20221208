package com.training.spring.di.rest.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContainsImpl implements ConstraintValidator<Contains, String> {

    private Contains anno;

    @Override
    public void initialize(Contains constraintAnnotation) {
        anno = constraintAnnotation;
    }

    @Override
    public boolean isValid(String value,
                           ConstraintValidatorContext context) {
        String[] values = anno.value();
        for (String s : values) {
            if (value.contains(s)) {
                return false;
            }
        }
        return true;
    }

}
