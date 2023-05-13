package com.aatorganicos.aatorganicos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aatorganicos.aatorganicos.model.Usuario;
import com.aatorganicos.aatorganicos.repository.IUsuarioRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/usuario")
@AllArgsConstructor
public class UsuarioController {

    private final IUsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> usuario() {
        return usuarioRepository.findAll();
    }

}
