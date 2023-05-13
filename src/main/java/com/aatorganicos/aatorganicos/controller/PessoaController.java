package com.aatorganicos.aatorganicos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aatorganicos.aatorganicos.model.Pessoa;
import com.aatorganicos.aatorganicos.repository.IPessoaRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/pessoa")
@AllArgsConstructor
public class PessoaController {

    private final IPessoaRepository pessoaRepository;

    @GetMapping
    public List<Pessoa> pessoa() {
        return pessoaRepository.findAll();
    }

}
