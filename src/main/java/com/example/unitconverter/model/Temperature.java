package com.example.unitconverter.model;

public class Temperature {
    private Double celsius;
    private Double fahrenheit;
    private Double kelvin;

    public Temperature(){}

    public Double getCelsius() {
        return this.celsius;
    }

    public void setCelsius(Double celsius) {
        this.celsius = celsius;
    }

    public Double getFahrenheit() {
        return this.fahrenheit;
    }

    public void setFahrenheit(Double fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public Double getKelvin() {
        return this.kelvin;
    }

    public void setKelvin(Double kelvin) {
        this.kelvin = kelvin;
    }
}