package com.aatorganicos.aatorganicos.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
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

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;

@Validated
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
    public ResponseEntity<Endereco> enderecoPorId(@PathVariable @NotNull @Positive Long id) {
        return enderecoRepository.findById(id)
                .map(data -> ResponseEntity.ok().body(data))
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Endereco criarEndereco(@RequestBody @Valid Endereco endereco) {

        return enderecoRepository.save(endereco);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> atualizaEndereco(@PathVariable @NotNull @Positive Long id, @RequestBody Endereco endereco) {
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEndereco(@PathVariable @NotNull @Positive Long id) {
        return enderecoRepository.findById(id)
                .map(data -> {
                    enderecoRepository.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
