package com.aluracursos.frases_peliculas.repository;

import com.aluracursos.frases_peliculas.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

}
