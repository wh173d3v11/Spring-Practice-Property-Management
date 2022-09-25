package com.example.propertymanagement.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor //will create an Empty Constructor
public class BusinessException extends RuntimeException {
    // Exception are Checked Exception
    // RuntimeExceptions are UnChecked Exceptions
    private List<ErrorModel> errorModels ;

    public BusinessException(List<ErrorModel> errors){
        this.errorModels = errors;
    }
}
