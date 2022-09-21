package com.example.propertymanagement.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "USER_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //AUTO is basically it will use as SEQUENCE
    private Long id;
    private String ownerName;
    @Column(name = "PROPERTY_EMAIL", nullable = false)
    private String ownerEmail;
    private String phone;
    private String password;
}
