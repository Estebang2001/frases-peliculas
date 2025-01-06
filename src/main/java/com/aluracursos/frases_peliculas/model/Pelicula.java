package com.aluracursos.frases_peliculas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Peliculas")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    private String poster;
    private String personaje;
    private String frase;

    public Pelicula(){

    }

    public Pelicula(String titulo, String poster, String personaje, String frase) {
        this.titulo = titulo;
        this.poster = poster;
        this.personaje = personaje;
        this.frase = frase;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getPoster() {
        return poster;
    }

    public String getPersonaje() {
        return personaje;
    }

    public String getFrase() {
        return frase;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", poster='" + poster + '\'' +
                ", personaje='" + personaje + '\'' +
                ", frase='" + frase + '\'' +
                '}';
    }
}
