package com.example.unitconverter.controller;

import com.example.unitconverter.model.Length;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LengthController {

    public enum units {
        mile, kilometer, yard, meter, centimeter, foot, inch, millimeter
    }

    @GetMapping("/length")
    public ResponseEntity<?> length(){
        return new ResponseEntity<>(units.values(), HttpStatus.OK);
    }

    @GetMapping("/length/{unit}")
    public ResponseEntity<?> defaultLength(@PathVariable String unit) {
        return convert(unit,1.0);
    }

    private ResponseEntity<?> convert(String unit, Double amount) {

        switch (unit){
            case "mile"      : return  convertMile(amount);
            case "kilometer" : return convertKilometer(amount);
            // case "yard"      : return convertYard(amount);
            // case "meter"     : return convertCentimeter(amount);
            // case "foot"      : return convertFoot(amount);
            // case "inch"      : return convertInch(amount);
            // case "millimeter": return convertMillimeter(amount);
            default:return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There was a problem getting the resource."); 
        }
    }


    private ResponseEntity<?> convertMile(Double amount) {
        Length l = new Length();
        l.setMile(amount);
        l.setKilometer(amount*1.60934);
        l.setYard(amount*1760);
        l.setMeter(amount*1.60934*100);
        l.setFoot(amount*5280);
        l.setInch(amount*63360);
        l.setMillimeter(amount*1609000);
        return new ResponseEntity<>(l, HttpStatus.OK);
    }
    
    private ResponseEntity<?> convertKilometer(Double amount) {
        Length l = new Length();
        l.setKilometer(amount);
        l.setMile(amount/1.60934);
        l.setYard(amount*1093.61);
        l.setMeter(amount*1000);
        l.setFoot(amount*3280.84);
        l.setInch(amount*63360);
        l.setMillimeter(amount*1609000);

        return new ResponseEntity<>(l, HttpStatus.OK);
 }
    


}