package com.example.propertymanagement.service;

import com.example.propertymanagement.model.UserDto;

public interface UserService {
    UserDto register(UserDto userDto);

    UserDto login(String email, String password);
}
