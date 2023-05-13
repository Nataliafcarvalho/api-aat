package com.aatorganicos.aatorganicos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aatorganicos.aatorganicos.model.Endereco;
import com.aatorganicos.aatorganicos.repository.IEnderecoRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/endereco")
@AllArgsConstructor
public class EnderecoController {

    private final IEnderecoRepository enderecoRepository;

    @GetMapping
    public List<Endereco> endereco() {
        return enderecoRepository.findAll();
    }

}
