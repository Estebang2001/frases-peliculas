package com.aluracursos.frases_peliculas.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosSerie(
        @JsonAlias("Title") String titulo,
        @JsonAlias("Poster") String poster


) {
    @Override
    public String titulo() {
        return titulo;
    }

    @Override
    public String poster() {
        return poster;
    }
}
