package com.aatorganicos.aatorganicos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    
    @GetMapping
    public String usuario() {
        return "Usuário";
    }

}
