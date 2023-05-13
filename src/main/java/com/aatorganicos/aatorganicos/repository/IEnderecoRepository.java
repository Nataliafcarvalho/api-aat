package com.aatorganicos.aatorganicos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aatorganicos.aatorganicos.model.Endereco;

@Repository
public interface IEnderecoRepository extends JpaRepository<Endereco, Long>{
    
}
