package com.aatorganicos.aatorganicos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aatorganicos.aatorganicos.model.Pessoa;

public interface IPessoaRepository extends JpaRepository<Pessoa, Long>{
    
}
