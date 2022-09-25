package com.example.propertymanagement.service.impl;

import com.example.propertymanagement.converter.UserConverter;
import com.example.propertymanagement.entity.UserEntity;
import com.example.propertymanagement.exception.BusinessException;
import com.example.propertymanagement.exception.ErrorModel;
import com.example.propertymanagement.model.UserDto;
import com.example.propertymanagement.repository.UserRepository;
import com.example.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDto register(UserDto userDto) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByOwnerEmail(userDto.getOwnerEmail());
        if (optionalUserEntity.isPresent()){
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("EMAIL_ALREADY_EXIST");
            errorModel.setMessage("The Email which youa re trying to register is already Exist.");
            errorModelList.add(errorModel);
            //if we have multiple error code, we can add in it errorModelList arrays
            throw new BusinessException(errorModelList);
        }

        UserEntity userEntity = userConverter.convertDtoToEntity(userDto);
        userEntity = userRepository.save(userEntity);
        userDto = userConverter.convertEntityToDto(userEntity);
        return userDto;
    }

    @Override
    public UserDto login(String email, String password) {
        UserDto userDto = null;
        Optional<UserEntity> userEntity = userRepository.findByOwnerEmailAndPassword(email, password);
        if (userEntity.isPresent()) {
            userDto = userConverter.convertEntityToDto(userEntity.get());
        } else {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("INVALID_LOGIN");
            errorModel.setMessage("Incorrect Email or Password.");
            errorModelList.add(errorModel);
            //if we have multiple error code, we can add in it errorModelList arrays
            throw new BusinessException(errorModelList);
        }
        return userDto;
    }
}
