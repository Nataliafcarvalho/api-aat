package com.aatorganicos.aatorganicos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aatorganicos.aatorganicos.model.Pessoa;

@Repository
public interface IPessoaRepository extends JpaRepository<Pessoa, Long>{
    
}
