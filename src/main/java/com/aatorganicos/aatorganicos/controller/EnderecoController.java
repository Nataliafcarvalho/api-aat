package com.aatorganicos.aatorganicos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aatorganicos.aatorganicos.model.Endereco;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {
    
    @GetMapping
    public List<Endereco> endereco() {
        return null;
    }

}
