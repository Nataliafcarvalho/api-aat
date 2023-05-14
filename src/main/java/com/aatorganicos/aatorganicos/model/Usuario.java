package com.aatorganicos.aatorganicos.model;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @NotBlank
    @NotNull
    @Length(min = 3, max = 20)
    @Column(length = 20, nullable = false)
    private String Login;

    @NotBlank
    @NotNull
    @Length(min = 6, max = 16)
    @Column(length = 16, nullable = false)
    private String Senha;

    private Long PessoaId;

}
