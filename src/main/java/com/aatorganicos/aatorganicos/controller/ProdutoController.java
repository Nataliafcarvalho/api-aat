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

import com.aatorganicos.aatorganicos.model.Produto;
import com.aatorganicos.aatorganicos.repository.IProdutoRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;

@Validated
@RestController
@RequestMapping("/api/produto")
@AllArgsConstructor
public class ProdutoController {

    private final IProdutoRepository produtoRepository;

    @GetMapping
    public @ResponseBody List<Produto> produto() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> produtoPorId(@PathVariable @NotNull @Positive Long id) {
        return produtoRepository.findById(id)
                .map(data -> ResponseEntity.ok().body(data))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Produto criarProduto(@RequestBody @Valid Produto produto) {

        return produtoRepository.save(produto);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizaProduto(@PathVariable @NotNull @Positive Long id, @RequestBody Produto produto) {
        return produtoRepository.findById(id)
                .map(data -> {
                    data.setNome(produto.getNome());
                    data.setDescricao(produto.getDescricao());
                    data.setCategoriaId(produto.getCategoriaId());
                    Produto updated = produtoRepository.save(data);
                    return ResponseEntity.ok().body(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable @NotNull @Positive Long id) {
        return produtoRepository.findById(id)
                .map(data -> {
                    produtoRepository.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
}
