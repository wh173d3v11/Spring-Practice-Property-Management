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
import java.util.Optional;

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

    @Override
    public PropertyModel updateProperty(PropertyModel propertyModel, Long propertyId) {
        //this is full update
        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId); //data from db
        if (optEn.isPresent()) {
            PropertyEntity pe = optEn.get();
            pe.setTitle(propertyModel.getTitle());
            pe.setAddress(propertyModel.getAddress());
            pe.setDescription(propertyModel.getDescription());
            pe.setOwnerEmail(propertyModel.getOwnerEmail());
            pe.setOwnerName(propertyModel.getOwnerName());
            pe.setPrice(propertyModel.getPrice());
            propertyRepository.save(pe);

            //setting id
            propertyModel.setId(pe.getId());
        }
        return propertyModel;
    }

    @Override
    public PropertyModel updatePropertyDescription(PropertyModel propertyModel, Long propertyId) {
        //this is partial  update
        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId); //data from db
        PropertyModel dto = null;
        if (optEn.isPresent()) {
            PropertyEntity pe = optEn.get();
            pe.setDescription(propertyModel.getDescription());
            dto = propertyConverter.convertEntityToDto(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public PropertyModel updatePropertyPrice(PropertyModel propertyModel, Long propertyId) {
        //this is partial update
        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId); //data from db
        if (optEn.isPresent()) {
            PropertyEntity pe = optEn.get();
            pe.setPrice(propertyModel.getPrice());
            propertyRepository.save(pe);
            //setting dto data
            propertyModel = propertyConverter.convertEntityToDto(pe);
        }
        return propertyModel;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }
}
