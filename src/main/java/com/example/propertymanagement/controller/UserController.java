package com.example.propertymanagement.controller;

import com.example.propertymanagement.model.UserDto;
import com.example.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    //http://localhost:8080/api/v1/user/register
    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody UserDto userDto) {
        userDto = userService.register(userDto);
        ResponseEntity<UserDto> resp = new ResponseEntity<UserDto>(userDto, HttpStatus.CREATED);
        return resp;
    }

    //http://localhost:8080/api/v1/user/register
    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody UserDto userDto) {
        userDto = userService.login(userDto.getOwnerEmail(),userDto.getPassword());
        ResponseEntity<UserDto> resp = new ResponseEntity<UserDto>(userDto, HttpStatus.CREATED);
        return resp;
    }

}
