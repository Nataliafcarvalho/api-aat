package com.aatorganicos.aatorganicos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.aatorganicos.aatorganicos.model.Categoria;
import com.aatorganicos.aatorganicos.repository.ICategoriaRepository;

@SpringBootApplication
public class AatOrganicosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AatOrganicosApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(ICategoriaRepository categoriaRepository) {
		return args -> {
			categoriaRepository.deleteAll();

			Categoria c = new Categoria();
			
			c.setNome("Teste");
			c.setDescricao("Teste descrição");

			categoriaRepository.save(c);
		};
	};

}
