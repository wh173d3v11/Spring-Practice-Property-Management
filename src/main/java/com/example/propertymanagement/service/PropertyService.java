package com.example.propertymanagement.service;

import com.example.propertymanagement.model.PropertyModel;

//factory design pattern.(seperating impl and interface service class)
public interface PropertyService {
    public PropertyModel saveProperty(PropertyModel propertyModel);
}
