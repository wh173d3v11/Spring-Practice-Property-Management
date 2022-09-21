package com.example.propertymanagement.service;

import com.example.propertymanagement.model.PropertyModel;

import java.util.List;

//factory design pattern.(seperating impl and interface service class)
public interface PropertyService {
    PropertyModel saveProperty(PropertyModel propertyModel);

    List<PropertyModel> getAllProperties();

    PropertyModel updateProperty(PropertyModel propertyModel, Long propertyId);
    PropertyModel updatePropertyDescription(PropertyModel propertyModel, Long propertyId);
    PropertyModel updatePropertyPrice(PropertyModel propertyModel, Long propertyId);

}
