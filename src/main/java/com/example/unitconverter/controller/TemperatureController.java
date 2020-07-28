package com.example.unitconverter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.unitconverter.model.Temperature;


@RestController
public class TemperatureController {

    public enum units {
        fahrenheit, celsius, kelvin
    }

    @GetMapping("/temperature")
    public ResponseEntity<?> temperature(){
        return new ResponseEntity<>(units.values(),HttpStatus.OK);
    }
    @GetMapping("/temperature/{unit}")
    public ResponseEntity<?> defaultTemperature(@PathVariable String unit){
        return convert(unit, 1.0);
    }

    @GetMapping("/temperature/{unit}/{amount}")
    public ResponseEntity<?> defaultTemperature(@PathVariable String unit, @PathVariable Double amount){
        return convert(unit, amount);
    }


    private ResponseEntity<?> convert(String unit, Double amount) {

        if ("celsius".equals(unit) || "fahrenheit".equals(unit) || "kelvin".equals(unit)) {
            return convertTemperature(unit, amount);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There was a problem getting the resource");
    }
    
    private ResponseEntity<?> convertTemperature(String unit, Double amount) {
        Temperature t = new Temperature();
        if ("celsius".equals(unit)) {
            t.setCelsius(amount);
            t.setFahrenheit((amount*1.8)+32.0);
            t.setKelvin(amount+273.15);
        } else if ("fahrenheit".equals(unit)) {
            t.setFahrenheit(amount);
            t.setCelsius((amount - 32)*0.55);
            t.setKelvin((amount - 32)*0.55+273.15);
        } else if ("kelvin".equals(unit)) {
            t.setKelvin(amount);
            t.setCelsius(amount-273.15);
            t.setFahrenheit((amount-273.15)*1.8+32.0);
        }
        return new ResponseEntity<>(t,HttpStatus.OK);
    }
}