package com.example.propertymanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
//Centralized Class, going to handle Exeptions.
public class CustomExceptionHandler {

    @ExceptionHandler(BusinessException.class/*Type of Exception*/)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException bEx) {
        System.out.println("BusinessException is Thrown");
        return new ResponseEntity<List<ErrorModel>>(bEx.getErrorModels(), HttpStatus.BAD_REQUEST);
    }

}
