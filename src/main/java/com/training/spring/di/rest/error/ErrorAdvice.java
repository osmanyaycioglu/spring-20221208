package com.training.spring.di.rest.error;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(IllegalArgumentException exp) {
        return ErrorObj.builder()
                       .withErrorDesc(exp.getMessage())
                       .withErrorCode(1066)
                       .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(MethodArgumentNotValidException exp) {
        return ErrorObj.builder()
                       .withErrorDesc("validation error")
                       .withErrorCode(1066)
                       .withSubErrors(exp.getAllErrors()
                                         .stream()
                                         .map(se -> ErrorObj.builder()
                                                            .withErrorDesc(se.toString())
                                                            .withErrorCode(1088)
                                                            .build())
                                         .collect(Collectors.toUnmodifiableList())
                       )
                       .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorObj handleException(Exception exp) {
        exp.printStackTrace();
        if (exp instanceof NullPointerException) {
            return ErrorObj.builder()
                           .withErrorDesc("error")
                           .withErrorCode(5501)
                           .build();
        }
        return ErrorObj.builder()
                       .withErrorDesc(exp.getMessage())
                       .withErrorCode(5500)
                       .build();
    }
}
