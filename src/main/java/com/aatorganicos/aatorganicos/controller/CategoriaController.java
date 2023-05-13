package com.aatorganicos.aatorganicos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aatorganicos.aatorganicos.model.Categoria;
import com.aatorganicos.aatorganicos.repository.ICategoriaRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/categoria")
@AllArgsConstructor
public class CategoriaController {

    private final ICategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> categoria() {
        return categoriaRepository.findAll();
    }
    
}
