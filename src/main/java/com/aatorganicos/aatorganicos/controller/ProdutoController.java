package com.aatorganicos.aatorganicos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aatorganicos.aatorganicos.model.Produto;
import com.aatorganicos.aatorganicos.repository.IProdutoRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/produto")
@AllArgsConstructor
public class ProdutoController {

    private final IProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> produto() {
        return produtoRepository.findAll();
    }
    
}
