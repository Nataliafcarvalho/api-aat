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

import com.aatorganicos.aatorganicos.model.Pessoa;
import com.aatorganicos.aatorganicos.repository.IPessoaRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;

@Validated
@RestController
@RequestMapping("/api/pessoa")
@AllArgsConstructor
public class PessoaController {

    private final IPessoaRepository pessoaRepository;

    @GetMapping
    public @ResponseBody List<Pessoa> pessoa() {
        return pessoaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> pessoaPorId(@PathVariable @NotNull @Positive Long id) {
        return pessoaRepository.findById(id)
                .map(data -> ResponseEntity.ok().body(data))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Pessoa criarPessoa(@RequestBody @Valid Pessoa pessoa) {

        return pessoaRepository.save(pessoa);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizaPessoa(@PathVariable @NotNull @Positive Long id, @RequestBody Pessoa pessoa) {
        return pessoaRepository.findById(id)
                .map(data -> {
                    data.setCpf(pessoa.getCpf());
                    data.setDtNascimento(pessoa.getDtNascimento());
                    data.setEmail(pessoa.getEmail());
                    data.setNome(pessoa.getNome());
                    data.setSexo(pessoa.getSexo());
                    Pessoa updated = pessoaRepository.save(data);
                    return ResponseEntity.ok().body(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoa(@PathVariable @NotNull @Positive Long id) {
        return pessoaRepository.findById(id)
                .map(data -> {
                    pessoaRepository.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.noContent().build());
    }

}
