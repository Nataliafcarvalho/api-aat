package com.aatorganicos.aatorganicos.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    public @ResponseBody List<Endereco> endereco() {
        return enderecoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> enderecoPorId(@PathVariable Long id) {
        return enderecoRepository.findById(id)
                .map(data -> ResponseEntity.ok().body(data))
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Endereco criarEndereco(@RequestBody Endereco endereco) {

        return enderecoRepository.save(endereco);

    }

    @PutMapping
    public ResponseEntity<Endereco> atualizaEndereco(@PathVariable Long id, @RequestBody Endereco endereco) {
        return enderecoRepository.findById(id)
                .map(data -> {
                    data.setBairro(endereco.getBairro());
                    data.setCep(endereco.getCep());
                    data.setCidade(endereco.getCidade());
                    data.setComplemento(endereco.getComplemento());
                    data.setLogradouro(endereco.getLogradouro());
                    Endereco updated = enderecoRepository.save(data);
                    return ResponseEntity.ok().body(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
