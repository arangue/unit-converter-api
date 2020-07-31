package com.example.unitconverter.controller;

import com.example.unitconverter.model.Weight;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeightController {

    public enum units {
        stone, pound, ounce, kilogram, gram, milligram
    }

    @GetMapping("/weight")
    public ResponseEntity<?> weight(){
        return new ResponseEntity<>(units.values(), HttpStatus.OK);
    }

    @GetMapping("/weight/{unit}")
    public ResponseEntity<?> defaultWeight(@PathVariable String unit){
       return convert(unit, 1.0);
    }

    @GetMapping("/weight/{unit}/{amount}")
    public ResponseEntity<?> defaultWeight(@PathVariable String unit, @PathVariable Double amount){
       return convert(unit, amount);
    }

    private ResponseEntity<?> convert(String unit, Double amount) {
        switch(unit) {
            case "stone"    : return convertStone(unit,amount);
            case "pound"    : return convertPound(unit,amount);
            case "ounce"    : return convertOunce(unit,amount);
            case "kilogram" : return convertKilogram(unit,amount);
            case "gram"     : return convertGram(unit,amount);
            case "milligram": return convertMilligram(unit,amount);            
            default         : return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There was a problem getting the resource.");
        }
    }

    private ResponseEntity<?> convertMilligram(String unit, Double amount) {
        Weight w = new Weight();

        w.setMilligram(amount);
        w.setGram(amount/1000);
        w.setKilogram(amount/1000000);
        w.setStone(amount/6350000);
        w.setPound(amount/453592);
        w.setOunce(amount/28350);

        return new ResponseEntity<>(w,HttpStatus.OK);
    }

    private ResponseEntity<?> convertGram(String unit, Double amount) {
        Weight w = new Weight();

        w.setGram(amount);
        w.setMilligram(amount*1000);
        w.setKilogram(amount/1000);
        w.setStone(amount/6350);
        w.setPound(amount/453.592);
        w.setOunce(amount/28.35);

        return new ResponseEntity<>(w,HttpStatus.OK);
    }

    private ResponseEntity<?> convertKilogram(String unit, Double amount) {
        Weight w = new Weight();

        w.setKilogram(amount);
        w.setGram(amount*1000);
        w.setMilligram(amount*1000000);
        w.setStone(amount/6.35);
        w.setPound(amount*2.205);
        w.setOunce(amount*35.274);

        return new ResponseEntity<>(w,HttpStatus.OK);
    }

    private ResponseEntity<?> convertOunce(String unit, Double amount) {
        Weight w = new Weight();

        w.setOunce(amount);
        w.setStone(amount/224);
        w.setPound(amount/16);
        w.setKilogram(amount/35.274);
        w.setGram(amount*28.3495);
        w.setMilligram(amount*28349.5);

        return new ResponseEntity<>(w,HttpStatus.OK);
    }

    private ResponseEntity<?> convertPound(String unit, Double amount) {
        Weight w = new Weight();

        w.setPound(amount);
        w.setStone(amount/14);
        w.setOunce(amount*16);
        w.setKilogram(amount*0.453592);
        w.setGram(amount*453.592);
        w.setMilligram(amount*453592);

        return new ResponseEntity<>(w,HttpStatus.OK);
    }

    private ResponseEntity<?> convertStone(String unit, Double amount) {
        Weight w = new Weight();

        w.setStone(amount);
        w.setPound(amount*14);
        w.setOunce(amount*224);
        w.setKilogram(amount*6.3529);
        w.setGram(amount*6350.29);
        w.setMilligram(amount*6350290);

        return new ResponseEntity<>(w,HttpStatus.OK);
    }
    
}