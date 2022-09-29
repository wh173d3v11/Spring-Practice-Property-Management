package com.example.propertymanagement.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
//Centralized Class, going to handle Exceptions.
public class CustomExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorModel>> handleFieldValidationException(MethodArgumentNotValidException manve) {
        logger.debug("Field Validation Exception is Thrown");
        List<FieldError> fieldErrorList = manve.getFieldErrors();

        List<ErrorModel> errorModelList = new ArrayList<>();
        for (FieldError fe : fieldErrorList) {
            logger.info("Inside Field Validation {} - {}", fe.getField(), fe.getDefaultMessage());
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode(fe.getField());
            errorModel.setMessage(fe.getDefaultMessage());
            errorModelList.add(errorModel);
        }
        return new ResponseEntity<List<ErrorModel>>(errorModelList, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BusinessException.class/*Type of Exception*/)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException bEx) {
        System.out.println("BusinessException is Thrown");
        for (ErrorModel em: bEx.getErrorModels()){
            logger.debug("BusinessException is Thrown debug level: {} - {}",em.getCode(),em.getMessage());
            logger.info("BusinessException is Thrown info level: {} - {}",em.getCode(),em.getMessage());
            logger.warn("BusinessException is Thrown warn level: {} - {}",em.getCode(),em.getMessage());
            logger.error("BusinessException is Thrown error level : {} - {}",em.getCode(),em.getMessage());
        }
        return new ResponseEntity<List<ErrorModel>>(bEx.getErrorModels(), HttpStatus.BAD_REQUEST);
    }

}
