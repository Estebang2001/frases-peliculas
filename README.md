# Proyecto de Frases de Películas y Series

Este proyecto es una aplicación Java basada en Spring Boot que permite cargar datos de series y películas desde una API externa, almacenarlos en una base de datos y exponerlos a través de un controlador REST.

## Requisitos

- Java 17 o superior
- Maven 3.6.0 o superior
- Base de datos compatible con JPA (por ejemplo, MySQL, PostgreSQL, H2)

## Configuración

1. Clona el repositorio:
    ```sh
    git clone https://github.com/tu-usuario/tu-repositorio.git
    cd tu-repositorio
    ```

2. Configura la base de datos en el archivo `application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/tu_base_de_datos
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
    spring.jpa.hibernate.ddl-auto=update
    ```

3. Compila y ejecuta la aplicación:
    ```sh
    mvn clean install
    mvn spring-boot:run
    ```

## Uso

### Cargar Series

1. Ejecuta la clase `Principal` para iniciar el menú interactivo.
2. Selecciona la opción `1` para cargar una serie.
3. Ingresa el nombre de la serie.
4. Ingresa el nombre del personaje y una frase icónica.
5. Los datos se guardarán en la base de datos.

### Obtener Frases

1. Accede al endpoint `/series/frases` para obtener una frase aleatoria de la base de datos:
    ```sh
    curl http://localhost:8080/series/frases
    ```

## Estructura del Proyecto

- `src/main/java/com/aluracursos/frases_peliculas/principal/Principal.java`: Clase principal que maneja el menú interactivo.
- `src/main/java/com/aluracursos/frases_peliculas/controller/PeliculaController.java`: Controlador REST para exponer los datos.
- `src/main/java/com/aluracursos/frases_peliculas/model/Pelicula.java`: Entidad JPA que representa una película.
- `src/main/java/com/aluracursos/frases_peliculas/repository/PeliculaRepository.java`: Repositorio JPA para acceder a los datos de las películas.
- `src/main/java/com/aluracursos/frases_peliculas/services/ConsumoAPI.java`: Servicio para consumir la API externa.
- `src/main/java/com/aluracursos/frases_peliculas/services/ConvierteDatos.java`: Servicio para convertir los datos JSON a objetos Java.
- `src/main/java/com/aluracursos/frases_peliculas/config/CorsConfiguration.java`: Configuración de CORS para permitir solicitudes desde el frontend.
