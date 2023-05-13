package com.aatorganicos.aatorganicos.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(length = 120, nullable = false)
    private String Nome;

    @Column(length = 120, nullable = false)
    private String Email;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate DtNascimento;

    @Column(length = 1, nullable = true)
    private String Sexo;

    @Column(length = 15, nullable = true)
    private Number Cpf;

}
