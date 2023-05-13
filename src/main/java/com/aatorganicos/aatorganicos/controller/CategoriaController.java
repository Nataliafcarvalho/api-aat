package com.aatorganicos.aatorganicos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aatorganicos.aatorganicos.model.Categoria;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @GetMapping
    public List<Categoria> categoria() {
        return null;
    }
    
}
