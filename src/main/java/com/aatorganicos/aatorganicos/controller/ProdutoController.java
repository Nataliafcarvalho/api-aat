package com.aatorganicos.aatorganicos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aatorganicos.aatorganicos.model.Produto;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @GetMapping
    public List<Produto> produto() {
        return null;
    }
    
}
