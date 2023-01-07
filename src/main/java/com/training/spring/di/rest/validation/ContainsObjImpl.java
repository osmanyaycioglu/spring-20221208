package com.training.spring.di.rest.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ContainsObjImpl implements ConstraintValidator<ContainsObject, Object> {

    private ContainsObject anno;


    @Override
    public void initialize(ContainsObject constraintAnnotation) {
        anno = constraintAnnotation;
    }

    @Override
    public boolean isValid(Object value,
                           ConstraintValidatorContext context) {
        Class<?> aClass = value.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        List<String> errors = new ArrayList<>();
        for (Field declaredField : declaredFields) {
            Class<?> type = declaredField.getType();
            if (type.getName()
                    .equals(String.class.getName())) {
                String[] values = anno.value();
                for (String s : values) {
                    try {
                        declaredField.setAccessible(true);
                        String str = (String) declaredField.get(value);
                        if (str.contains(s)) {
                            errors.add("Field : " + declaredField.getName() + " " + s + "  barındırmamalı");
                        }
                    } catch (Exception eParam) {
                        eParam.printStackTrace();
                    }
                }

            }
        }
        if (!errors.isEmpty()) {
            context.disableDefaultConstraintViolation();
            StringBuilder stringBuilder = new StringBuilder();
            for (String error : errors) {
                stringBuilder.append(error)
                             .append(" -- ");
            }
            ConstraintValidatorContext.ConstraintViolationBuilder constraintViolationBuilder = context.buildConstraintViolationWithTemplate(stringBuilder.toString());
            constraintViolationBuilder.addConstraintViolation();
            return false;
        }
        return true;
    }
}
