package com.example.propertymanagement.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyModel {
    private Long id;
    private String title;
    private String description;
    private String ownerName;
    private String ownerEmail;
    private String price;
    private String address;
}
