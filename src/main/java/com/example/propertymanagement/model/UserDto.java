package com.example.propertymanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
//JsonIgnoreProperties and JsonInclude - sending only needed variables and ignore all null variables.
public class UserDto {
    private Long id;
    private String ownerName;
    @NotNull(message = "Owner Email is mandatory") //hibernate Validator
    @NotEmpty(message = "Owner Email cannot be Empty")
    @Size(min = 1, max = 50, message = "Owner Email Should be between 1 to 50 Characters in length")
    private String ownerEmail;
    private String phone;
    @NotNull(message = "Password cannot be null")
    @NotEmpty(message = "Password cannot be Empty")
    private String password;
}
