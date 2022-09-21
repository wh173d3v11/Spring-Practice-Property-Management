package com.example.propertymanagement.converter;

import com.example.propertymanagement.entity.UserEntity;
import com.example.propertymanagement.model.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity convertDtoToEntity(UserDto userDto) {
        UserEntity ue = new UserEntity();
        ue.setOwnerEmail(userDto.getOwnerEmail());
        ue.setOwnerName(userDto.getOwnerName());
        ue.setPhone(userDto.getPhone());
        ue.setPassword(userDto.getPassword());
        return ue;
    }

    public UserDto convertEntityToDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setOwnerEmail(userEntity.getOwnerEmail());
        userDto.setOwnerName(userEntity.getOwnerName());
        userDto.setPhone(userEntity.getPhone());
        userDto.setPassword(userEntity.getPassword());
        return userDto;
    }
}
