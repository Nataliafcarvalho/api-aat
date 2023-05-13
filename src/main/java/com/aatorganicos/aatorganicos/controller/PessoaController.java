package com.aatorganicos.aatorganicos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aatorganicos.aatorganicos.model.Pessoa;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {
    
    @GetMapping
    public List<Pessoa> pessoa() {
        return null;
    }

}
