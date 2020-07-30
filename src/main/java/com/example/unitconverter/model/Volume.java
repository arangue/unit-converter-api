package com.example.unitconverter.model;

public class Volume {
    
    private Double gallon; 
    private Double quart;
    private Double liter;
    private Double milliliter;
    
    public Volume(){};
    
    public Double getQuart() {
        return this.quart;
    }

    public void setQuart(Double quart) {
        this.quart = quart;
    }
    public Double getGallon() {
        return this.gallon;
    }

    public void setGallon(Double gallon) {
        this.gallon = gallon;
    }

    public Double getLiter() {
        return this.liter;
    }

    public void setLiter(Double liter) {
        this.liter = liter;
    }

    public Double getMilliliter() {
        return this.milliliter;
    }

    public void setMilliliter(Double milliliter) {
        this.milliliter = milliliter;
    }   
}