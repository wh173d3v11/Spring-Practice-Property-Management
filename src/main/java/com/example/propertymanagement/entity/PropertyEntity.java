package com.example.propertymanagement.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PROPERTY_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class PropertyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //AUTO is basically it will use as SEQUENCE
    private Long id;
    @Column(name = "PROPERTY_TITLE", nullable = false, length = 40)
    private String title;
    private String description;
    private String ownerName;
    @Column(name = "PROPERTY_EMAIL", nullable = false)
    private String ownerEmail;
    private String price;
    private String address;
}
