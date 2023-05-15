package com.aatorganicos.aatorganicos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aatorganicos.aatorganicos.model.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Long>{
    
}
