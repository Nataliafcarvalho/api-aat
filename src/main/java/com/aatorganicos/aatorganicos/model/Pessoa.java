package com.aatorganicos.aatorganicos.model;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @NotBlank
    @NotNull
    @Column(length = 120, nullable = false)
    private String Nome;

    @NotBlank
    @NotNull
    @jakarta.validation.constraints.Email
    @Column(length = 120, nullable = false)
    private String Email;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate DtNascimento;

    @NotBlank
    @NotNull
    @Length(max = 1)
    @Pattern(regexp = "M|F|O")
    @Column(length = 1, nullable = true)
    private String Sexo;

    @Length(max = 15)
    @Column(length = 15, nullable = true)
    private Number Cpf;

}
