package com.example.propertymanagement.controller;

import com.example.propertymanagement.model.PropertyModel;
import com.example.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @PostMapping("/properties")
    public PropertyModel saveProperty(@RequestBody PropertyModel propertyModel) {
        propertyService.saveProperty(propertyModel);
        System.out.println(propertyModel);
        return propertyModel;
    }

}
