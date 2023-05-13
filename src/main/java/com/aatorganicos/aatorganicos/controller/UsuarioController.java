package com.aatorganicos.aatorganicos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aatorganicos.aatorganicos.model.Usuario;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    
    @GetMapping
    public List<Usuario> usuario() {
        return null;
    }

}
