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

import com.aatorganicos.aatorganicos.model.Categoria;
import com.aatorganicos.aatorganicos.repository.ICategoriaRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;

@Validated
@RestController
@RequestMapping("/api/categoria")
@AllArgsConstructor
public class CategoriaController {

    private final ICategoriaRepository categoriaRepository;

    @GetMapping
    public @ResponseBody List<Categoria> categoria() {
        return categoriaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> categoriaPorId(@PathVariable @NotNull @Positive Long id) {
        return categoriaRepository.findById(id)
                .map(data -> ResponseEntity.ok().body(data))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Categoria criarCategoria(@RequestBody @Valid Categoria categoria) {

        return categoriaRepository.save(categoria);    
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizaCategoria(@PathVariable @NotNull @Positive Long id, @RequestBody Categoria categoria) {
        return categoriaRepository.findById(id)
                .map(data -> {
                    data.setNome(categoria.getNome());
                    data.setDescricao(categoria.getDescricao());
                    Categoria updated = categoriaRepository.save(data);
                    return ResponseEntity.ok().body(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable @NotNull @Positive Long id) {
        return categoriaRepository.findById(id)
                .map(data -> {
                    categoriaRepository.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
}
