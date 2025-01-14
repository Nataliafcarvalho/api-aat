package com.aatorganicos.aatorganicos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.aatorganicos.aatorganicos.model.Produto;
import com.aatorganicos.aatorganicos.repository.IProdutoRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class ProdutoService {
    
    private final IProdutoRepository produtoRepository;

    public ProdutoService(IProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> produto() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> produtoPorId(@NotNull @Positive Long id) {
        return produtoRepository.findById(id);
    }

    public Produto criarProduto(@Valid Produto produto) {
        return produtoRepository.save(produto);
    }

    public Optional<Produto> atualizaProduto(@NotNull @Positive Long id, Produto produto) {
        return produtoRepository.findById(id)
                .map(data -> {
                    data.setNome(produto.getNome());
                    data.setDescricao(produto.getDescricao());
                    data.setCategoriaId(produto.getCategoriaId());
                    return produtoRepository.save(data);
                });
    }

    public boolean deleteProduto(@NotNull @Positive Long id) {
        return produtoRepository.findById(id)
                .map(data -> {
                    produtoRepository.deleteById(id);
                    return true;
                })
                .orElse(false);
    }
    
}
