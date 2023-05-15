package com.aatorganicos.aatorganicos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aatorganicos.aatorganicos.model.Produto;

public interface IProdutoRepository extends JpaRepository<Produto, Long>{
    
}
