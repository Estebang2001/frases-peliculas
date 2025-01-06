package com.aluracursos.frases_peliculas.controller;

import com.aluracursos.frases_peliculas.model.Pelicula;
import com.aluracursos.frases_peliculas.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/series")
public class PeliculaController {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @GetMapping("/frases")
    public Pelicula obtenerFraseAleatoria() {
        List<Pelicula> peliculas = peliculaRepository.findAll();
        if (peliculas.isEmpty()) {
            return null; // O lanza una excepción si prefieres
        }
        Random random = new Random();
        int index = random.nextInt(peliculas.size());
        return peliculas.get(index);
    }
}
