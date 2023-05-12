package com.aatorganicos.aatorganicos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @GetMapping
    public String categoria() {
        return "Categoria";
    }
    
}
