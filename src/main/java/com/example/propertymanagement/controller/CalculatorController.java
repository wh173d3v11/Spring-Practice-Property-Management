package com.example.propertymanagement.controller;

import com.example.propertymanagement.model.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/calculator")
public class CalculatorController {


    @GetMapping("/add") //query parameter
    public Double add(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2) {
        return num1 + num2;
    }

    //    http://localhost:8080/api/v1/calculator/sum/1/2
    @GetMapping("/sub/{num1}/{num2}") //path parameter
    public Double sub(@PathVariable("num1") Double num1, @PathVariable("num2") Double num2) {
        return num1 - num2;
    }

    //http://localhost:8080/api/v1/calculator/sum/1/2?num3=4
    @GetMapping("/sum/{num1}/{num2}") //combination of query and path parameter.
    public Double sum(@PathVariable("num1") Double num1,
                      @PathVariable("num2") Double num2,
                      @RequestParam("num3") Double num3) {
        return num1 + num2 + num3;
    }

    @PostMapping("/mul")
    public ResponseEntity<Double> multiply(@RequestBody CalculatorDTO calculatorDto) {
        Double out = calculatorDto.getOne() * calculatorDto.getTwo();
        ResponseEntity<Double> outRes = new ResponseEntity<Double>(out, HttpStatus.CREATED);
        return outRes;
    }
}
