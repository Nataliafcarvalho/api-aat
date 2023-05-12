package com.aatorganicos.aatorganicos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {
    
    @GetMapping
    public String pessoa() {
        return "pessoa";
    }

}
