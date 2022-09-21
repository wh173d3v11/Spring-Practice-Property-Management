package com.example.propertymanagement.controller;

import com.example.propertymanagement.model.PropertyModel;
import com.example.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello DINESH";
    }

    //http://localhost:8080/api/v1/properties/properties
    @PostMapping("/save")
    public ResponseEntity<PropertyModel> saveProperty(@RequestBody PropertyModel propertyModel) {
        propertyModel = propertyService.saveProperty(propertyModel);
        ResponseEntity<PropertyModel> resp = new ResponseEntity<PropertyModel>(propertyModel, HttpStatus.CREATED);
        return resp;
    }

}
