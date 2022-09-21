package com.example.propertymanagement.controller;

import com.example.propertymanagement.model.PropertyModel;
import com.example.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {

    //from application configuration ":" -> if we used colon, if variable not present in configuration file, it wont throw error or null
    @Value("${pms.dummy:}")
    private String dummy;

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello DINESH";
    }

    //http://localhost:8080/api/v1/properties/save
    @PostMapping("/save")
    public ResponseEntity<PropertyModel> saveProperty(@RequestBody PropertyModel propertyModel) {
        propertyModel = propertyService.saveProperty(propertyModel);
        ResponseEntity<PropertyModel> resp = new ResponseEntity<PropertyModel>(propertyModel, HttpStatus.CREATED);
        return resp;
    }

    //http://localhost:8080/api/v1/properties/all
    @GetMapping("/all")
    public ResponseEntity<List<PropertyModel>> getAllProperties() {
        System.out.println(dummy);
        List<PropertyModel> propertiesList = propertyService.getAllProperties();
        ResponseEntity<List<PropertyModel>> resp = new ResponseEntity<List<PropertyModel>>(propertiesList, HttpStatus.OK);
        return resp;
    }

    //http://localhost:8080/api/v1/properties/update/1
    @PutMapping("/update/{propertyId}") //full update
    public ResponseEntity<PropertyModel> updateProperty(@RequestBody PropertyModel propertyModel, @PathVariable Long propertyId) {
        propertyModel = propertyService.updateProperty(propertyModel, propertyId);
        ResponseEntity<PropertyModel> resp = new ResponseEntity<PropertyModel>(propertyModel, HttpStatus.OK);
        return resp;
    }

    //http://localhost:8080/api/v1/properties/update-description/1
    @PatchMapping("/update-description/{propertyId}") //full update
    public ResponseEntity<PropertyModel> updatePropertyDescription(@RequestBody PropertyModel propertyModel, @PathVariable Long propertyId) {
        propertyModel = propertyService.updatePropertyDescription(propertyModel, propertyId);
        ResponseEntity<PropertyModel> resp = new ResponseEntity<PropertyModel>(propertyModel, HttpStatus.OK);
        return resp;
    }

    //http://localhost:8080/api/v1/properties/update-description/1
    @PatchMapping("/update-price/{propertyId}") //full update
    public ResponseEntity<PropertyModel> updatePropertyPrice(@RequestBody PropertyModel propertyModel, @PathVariable Long propertyId) {
        propertyModel = propertyService.updatePropertyPrice(propertyModel, propertyId);
        ResponseEntity<PropertyModel> resp = new ResponseEntity<PropertyModel>(propertyModel, HttpStatus.OK);
        return resp;
    }

    //http://localhost:8080/api/v1/properties/delete-property/1
    @DeleteMapping("/delete-property/{propertyId}")
    public ResponseEntity<String> deleteProperty(@PathVariable Long propertyId) {
        propertyService.deleteProperty(propertyId);
        ResponseEntity<String> resp = new ResponseEntity<String>("Success", HttpStatus.OK);
        return resp;
    }
}
