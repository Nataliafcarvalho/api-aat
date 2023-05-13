package com.aatorganicos.aatorganicos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aatorganicos.aatorganicos.model.Produto;

@Repository
public interface IProdutoRepository extends JpaRepository<Produto, Long>{
    
}
