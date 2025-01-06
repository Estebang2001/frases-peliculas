package com.aluracursos.frases_peliculas.services;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
