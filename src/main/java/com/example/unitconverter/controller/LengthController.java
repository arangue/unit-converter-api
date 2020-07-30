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

    @GetMapping("/length/{unit}/{amount}")
    public ResponseEntity<?> defaultLength(@PathVariable String unit, @PathVariable Double amount) {
        return convert(unit,amount);
    }

    private ResponseEntity<?> convert(String unit, Double amount) {

        switch (unit){
            case "mile"      : return convertMile(amount);
            case "kilometer" : return convertKilometer(amount);
            case "yard"      : return convertYard(amount);
            case "meter"     : return convertCentimeter(amount);
            case "foot"      : return convertFoot(amount);
            case "inch"      : return convertInch(amount);
            case "centimeter": return convertCentimeter(amount);
            case "millimeter": return convertMillimeter(amount);
            default:return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There was a problem getting the resource."); 
        }
    }


    private ResponseEntity<?> convertMillimeter(Double amount) {
        Length l = new Length();
        
        l.setMillimeter(amount);
        l.setMile(amount/1609340);
        l.setKilometer(amount/1000000);
        l.setYard(amount/914);
        l.setMeter(amount/1000);
        l.setFoot(amount/305);
        l.setInch(amount/25.4);

        return new ResponseEntity<>(l, HttpStatus.OK);
    }

    private ResponseEntity<?> convertInch(Double amount) {
        Length l = new Length();
        
        l.setInch(amount);
        l.setMile(amount/63360);
        l.setKilometer(amount/39370);
        l.setYard(amount/36);
        l.setMeter(amount/39.37);
        l.setFoot(amount/12);
        l.setCentimeter(amount*2.54);
        l.setMillimeter(amount*25.4);

        return new ResponseEntity<>(l, HttpStatus.OK);
    }

    private ResponseEntity<?> convertFoot(Double amount) {
        Length l = new Length();

        l.setFoot(amount);
        l.setMile(amount/5280);
        l.setKilometer(amount/3281);
        l.setYard(amount/3);
        l.setMeter(amount/3.281);
        l.setInch(amount*12);
        l.setCentimeter(amount*30.48);
        l.setMillimeter(amount*304.8);

        return new ResponseEntity<>(l, HttpStatus.OK);
    }

    private ResponseEntity<?> convertCentimeter(Double amount) {
        Length l = new Length();

        l.setCentimeter(amount);
        l.setMile(amount/160934);
        l.setKilometer(amount/100000);
        l.setYard(amount/91.44);
        l.setMeter(amount/100);
        l.setFoot(amount/30.48);
        l.setInch(amount/2.54);
        l.setMillimeter(amount/10);

        return new ResponseEntity<>(l, HttpStatus.OK);
    }

    private ResponseEntity<?> convertMile(Double amount) {
        Length l = new Length();

        l.setMile(amount);
        l.setKilometer(amount*1.60934);
        l.setYard(amount*1760);
        l.setMeter(amount*1.60934*100);
        l.setFoot(amount*5280);
        l.setInch(amount*63360);
        l.setCentimeter(amount*160934);
        l.setMillimeter(amount*1609000);

        return new ResponseEntity<>(l, HttpStatus.OK);
    }
    
    private ResponseEntity<?> convertKilometer(Double amount) {
        Length l = new Length();

        l.setKilometer(amount);
        l.setMile(amount/1.60934);
        l.setMeter(amount*1000);
        l.setYard(amount*1093.61);
        l.setFoot(amount*3280.84);
        l.setInch(amount*63360);
        l.setCentimeter(amount*100000);
        l.setMillimeter(amount*1609000);

        return new ResponseEntity<>(l, HttpStatus.OK);
    }

    private ResponseEntity<?> convertYard(Double amount) {
        Length l = new Length();

        l.setYard(amount);
        l.setKilometer(amount*914.4);
        l.setMile(amount/1760);
        l.setMeter(amount*0.9144);
        l.setFoot(amount*3);
        l.setInch(amount*36);
        l.setMillimeter(amount*914.4);

        return new ResponseEntity<>(l, HttpStatus.OK);
    }
}