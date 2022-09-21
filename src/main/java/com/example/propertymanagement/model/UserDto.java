package com.example.propertymanagement.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String ownerName;
    private String ownerEmail;
    private String phone;
    private String password;
}
