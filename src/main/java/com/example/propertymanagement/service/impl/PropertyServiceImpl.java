package com.example.propertymanagement.service.impl;

import com.example.propertymanagement.converter.PropertyConverter;
import com.example.propertymanagement.model.PropertyModel;
import com.example.propertymanagement.repository.PropertyRepository;
import com.example.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //-- Singleton purpose.
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyModel saveProperty(PropertyModel propertyModel) {
        //converting DTO to Entity is called Adapter Pattern.
        propertyRepository.save(propertyConverter.convertDtoToEntity(propertyModel));
        return null;
    }
}
