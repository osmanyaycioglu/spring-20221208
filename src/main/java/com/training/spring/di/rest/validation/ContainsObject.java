package com.training.spring.di.rest.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ContainsObjImpl.class })
public @interface ContainsObject {

    String[] value();

    String message() default "{javax.validation.constraints.ContainsObject.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };


}
