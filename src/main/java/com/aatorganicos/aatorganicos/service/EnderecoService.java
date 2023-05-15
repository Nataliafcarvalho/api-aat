package com.aatorganicos.aatorganicos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.aatorganicos.aatorganicos.model.Endereco;
import com.aatorganicos.aatorganicos.repository.IEnderecoRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class EnderecoService {
    
    private final IEnderecoRepository enderecoRepository;

    public EnderecoService(IEnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public List<Endereco> endereco() {
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> enderecoPorId(@NotNull @Positive Long id) {
        return enderecoRepository.findById(id);
    }

    public Endereco criarEndereco(@Valid Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Optional<Endereco> atualizaEndereco(@NotNull @Positive Long id, Endereco endereco) {
        return enderecoRepository.findById(id)
                .map(data -> {
                    data.setBairro(endereco.getBairro());
                    data.setCep(endereco.getCep());
                    data.setCidade(endereco.getCidade());
                    data.setComplemento(endereco.getComplemento());
                    data.setLogradouro(endereco.getLogradouro());
                    return enderecoRepository.save(data);
                });
    }

    public boolean deleteEndereco( @NotNull @Positive Long id) {
        return enderecoRepository.findById(id)
                .map(data -> {
                    enderecoRepository.deleteById(id);
                    return true;
                })
                .orElse(false);
    }

    
}