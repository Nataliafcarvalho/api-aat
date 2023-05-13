package com.aatorganicos.aatorganicos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(length = 120, nullable = false)
    private String Nome;

    @Column(length = 255, nullable = true)
    private String Descricao;

    private Long CategoriaId;

}
