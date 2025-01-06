package com.aluracursos.frases_peliculas;

import com.aluracursos.frases_peliculas.principal.Principal;
import com.aluracursos.frases_peliculas.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FrasesPeliculasApplication implements CommandLineRunner {

	@Autowired
	private PeliculaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(FrasesPeliculasApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Principal iniciar = new Principal(repository);
		iniciar.cargarSerie();

	}


}
