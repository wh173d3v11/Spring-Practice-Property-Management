package com.example.propertymanagement.converter;

import com.example.propertymanagement.entity.PropertyEntity;
import com.example.propertymanagement.model.PropertyModel;
import org.springframework.stereotype.Component;

@Component //singleton
public class PropertyConverter {

    public PropertyEntity convertDtoToEntity(PropertyModel propertyModel){
        //converting DTO to Entity is called Adapter Pattern.
        PropertyEntity pe = new PropertyEntity();
        pe.setTitle(propertyModel.getTitle());
        pe.setAddress(propertyModel.getAddress());
        pe.setDescription(propertyModel.getDescription());
        pe.setOwnerEmail(propertyModel.getOwnerEmail());
        pe.setOwnerName(propertyModel.getOwnerName());
        pe.setPrice(propertyModel.getPrice());
        return pe;
    }
}
