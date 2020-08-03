package com.example.unitconverter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UnitController {

    public enum units {
        volume, length, weight, temperature
    }

    @GetMapping("/")
    public ResponseEntity<?> api() {
        return new ResponseEntity<>(units.values(), HttpStatus.OK);
    }    
}