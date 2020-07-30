package com.example.unitconverter.controller;

import com.example.unitconverter.model.Volume;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VolumeController {

    public enum units {
        gallon, liter, quart, millimeter
    }

    @GetMapping("/volume")
    public ResponseEntity<?> volume(){
        return new ResponseEntity<>(units.values(), HttpStatus.OK);
    }

    @GetMapping("/volume/{unit}")
    public ResponseEntity<?> defaultLength(@PathVariable String unit){
        return convert(unit,1.0);
    }

    @GetMapping("/volume/{unit}/{amount}")
    public ResponseEntity<?> defaultLength(@PathVariable String unit, @PathVariable Double amount){
        return convert(unit,amount);
    }

    private ResponseEntity<?> convert(String unit, Double amount) {
        switch(unit) {
            case "gallon"     : return convertGallon(amount);
            case "liter"      : return convertLiter(amount);
            case "quart"      : return convertQuart(amount);
            case "milliliter" : return convertMillimeter(amount);
            default:return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There was a problem getting the resource."); 
        } 
    }

    private ResponseEntity<?> convertMillimeter(Double amount) {
        Volume v = new Volume();

        v.setMilliliter(amount);
        v.setGallon(amount/3785);
        v.setLiter(amount/1000);
        v.setQuart(amount*946);

        return new ResponseEntity<>(v,HttpStatus.OK);
    }

    private ResponseEntity<?> convertQuart(Double amount) {
        Volume v = new Volume();

        v.setQuart(amount);
        v.setGallon(amount/4);
        v.setLiter(amount*1.075);
        v.setMilliliter(amount*946.353);

        return new ResponseEntity<>(v,HttpStatus.OK);
    }

    private ResponseEntity<?> convertLiter(Double amount) {
        Volume v = new Volume();

        v.setLiter(amount);
        v.setGallon(amount/3.785);
        v.setQuart(amount/1.05699);
        v.setMilliliter(amount*1000);

        return new ResponseEntity<>(v,HttpStatus.OK);
    }

    private ResponseEntity<?> convertGallon(Double amount) {
        Volume v = new Volume();

        v.setGallon(amount);
        v.setLiter(amount*3.785);
        v.setQuart(amount*4);
        v.setMilliliter(amount*3785);

        return new ResponseEntity<>(v,HttpStatus.OK);
    }

    
}