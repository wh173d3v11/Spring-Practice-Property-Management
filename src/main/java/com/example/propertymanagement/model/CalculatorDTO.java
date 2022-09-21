package com.example.propertymanagement.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CalculatorDTO {
    public Double getOne() {
        return one;
    }

    public void setOne(Double one) {
        this.one = one;
    }

    public Double getTwo() {
        return two;
    }

    public void setTwo(Double two) {
        this.two = two;
    }

    private Double one;
    @JsonProperty("two")
    private Double two;
}
