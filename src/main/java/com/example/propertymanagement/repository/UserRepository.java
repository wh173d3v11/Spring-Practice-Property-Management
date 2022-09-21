package com.example.propertymanagement.repository;

import com.example.propertymanagement.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    //custom findBy methods
    //we can also use JPQL query also. check here - https://springframework.guru/spring-data-jpa-query/
    Optional<UserEntity> findByOwnerEmailAndPassword(String email, String password);
}
