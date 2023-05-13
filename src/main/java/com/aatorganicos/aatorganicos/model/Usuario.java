package com.aatorganicos.aatorganicos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(length = 20, nullable = false)
    private String Login;

    @Column(length = 16, nullable = false)
    private String Senha;

    private Long PessoaId;

}
