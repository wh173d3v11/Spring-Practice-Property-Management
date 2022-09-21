package com.example.propertymanagement.converter;

import com.example.propertymanagement.entity.PropertyEntity;
import com.example.propertymanagement.model.PropertyModel;
import org.springframework.stereotype.Component;

@Component //singleton
public class PropertyConverter {
//Adapter Pattern design.
    public PropertyEntity convertDtoToEntity(PropertyModel propertyModel) {
        //converting DTO to Entity is also called Adapter Pattern.
        PropertyEntity pe = new PropertyEntity();
        pe.setTitle(propertyModel.getTitle());
        pe.setAddress(propertyModel.getAddress());
        pe.setDescription(propertyModel.getDescription());
        pe.setOwnerEmail(propertyModel.getOwnerEmail());
        pe.setOwnerName(propertyModel.getOwnerName());
        pe.setPrice(propertyModel.getPrice());
        return pe;
    }

    public PropertyModel convertEntityToDto(PropertyEntity propertyEntity) {
        //converting Entity to DTO is also called Adapter Pattern.
        PropertyModel pm = new PropertyModel();
        pm.setId(propertyEntity.getId());
        pm.setTitle(propertyEntity.getTitle());
        pm.setAddress(propertyEntity.getAddress());
        pm.setDescription(propertyEntity.getDescription());
        pm.setOwnerEmail(propertyEntity.getOwnerEmail());
        pm.setOwnerName(propertyEntity.getOwnerName());
        pm.setPrice(propertyEntity.getPrice());
        return pm;
    }
}
