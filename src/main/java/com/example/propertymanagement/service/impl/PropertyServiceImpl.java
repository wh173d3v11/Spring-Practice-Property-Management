package com.example.propertymanagement.service.impl;

import com.example.propertymanagement.converter.PropertyConverter;
import com.example.propertymanagement.entity.PropertyEntity;
import com.example.propertymanagement.model.PropertyModel;
import com.example.propertymanagement.repository.PropertyRepository;
import com.example.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //-- Singleton purpose.
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyModel saveProperty(PropertyModel propertyModel) {
        //converting DTO to Entity is called Adapter Pattern.
        PropertyEntity pe = propertyRepository.save(propertyConverter.convertDtoToEntity(propertyModel));

        propertyModel = propertyConverter.convertEntityToDto(pe);
        return propertyModel;
    }

    @Override
    public List<PropertyModel> getAllProperties() {
        List<PropertyEntity> listOfProperty = (List<PropertyEntity>) propertyRepository.findAll();
        List<PropertyModel> pmList = new ArrayList<>();
        for (PropertyEntity pe : listOfProperty) {
            PropertyModel pmodel = propertyConverter.convertEntityToDto(pe);
            pmList.add(pmodel);
        }
        return pmList;
    }
}
