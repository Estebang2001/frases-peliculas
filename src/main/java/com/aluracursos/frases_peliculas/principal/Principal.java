package com.aluracursos.frases_peliculas.principal;

import com.aluracursos.frases_peliculas.model.DatosSerie;
import com.aluracursos.frases_peliculas.model.Pelicula;
import com.aluracursos.frases_peliculas.repository.PeliculaRepository;
import com.aluracursos.frases_peliculas.services.ConsumoAPI;
import com.aluracursos.frases_peliculas.services.ConvierteDatos;

import java.util.Scanner;

public class Principal {
    private Scanner sc = new Scanner(System.in);
    private final String URL_BASE = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=9ed0d578";
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private PeliculaRepository repositorio;

    public Principal(PeliculaRepository repository) {
        this.repositorio = repository;
    }

    public void cargarSerie() {
        int opcion;
        do {
            System.out.println("Menu:");
            System.out.println("1. Cargar serie");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("Digite el nombre de la serie:");
                    var nombreSerie = sc.nextLine();
                    try {
                        var json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+").toLowerCase() + API_KEY);
                        DatosSerie datos = conversor.obtenerDatos(json, DatosSerie.class);


                        // Tareas por hacer:

                        // Serializar los datos para obtener el String "Title" y "Poster"
                        System.out.println(datos);
                        // Una vez tenga titulo y poster, conseguir a traves del usuario una frase de la serie y el personaje que la dijo
                        System.out.println("Digite un personaje de la serie, seguido de una frase icónica de el.");
                        var nombrePersonaje = sc.nextLine();
                        System.out.println("Proceda con la frase");
                        var frase = sc.nextLine();
                        // Cargar al constructor de Pelicula los datos
                        Pelicula pelicula = new Pelicula(datos.titulo(),datos.poster(),nombrePersonaje,frase);
                        // Cargar los datos a la base de datos y crear un repositorio
                        repositorio.save(pelicula);
                        System.out.println(pelicula);
                        // Pasar los datos al front end a traves de un Controller

                    } catch (Exception e) {
                        System.out.println("La serie no pudo ser encontrada");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del menú...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }
}
