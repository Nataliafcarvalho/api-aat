package com.aatorganicos.aatorganicos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.aatorganicos.aatorganicos.model.Categoria;
import com.aatorganicos.aatorganicos.repository.ICategoriaRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class CategoriaService {

    private final ICategoriaRepository categoriaRepository;

    public CategoriaService(ICategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> categoria() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> categoriaPorId(@NotNull @Positive Long id) {
        return categoriaRepository.findById(id);
    }

    public Categoria criarCategoria(@Valid Categoria categoria) {
        return categoriaRepository.save(categoria);    
    }

    public Optional<Categoria> atualizaCategoria(@NotNull @Positive Long id, Categoria categoria) {
        return categoriaRepository.findById(id)
                .map(data -> {
                    data.setNome(categoria.getNome());
                    data.setDescricao(categoria.getDescricao());
                    return categoriaRepository.save(data);
                });
    }

    public boolean deleteCategoria(@NotNull @Positive Long id) {
        return categoriaRepository.findById(id)
                .map(data -> {
                    categoriaRepository.deleteById(id);
                    return true;
                })
                .orElse(false);
    }


}
