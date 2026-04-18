# Sistema de Biblioteca - Spring Data JPA y H2

Este proyecto es una aplicación RESTful desarrollada con Spring Boot que implementa persistencia de datos utilizando Spring Data JPA y una base de datos H2 en memoria.

## Características del Proyecto

- **Entidad**: `Libro` con campos: id, titulo, autor, isbn, anioPublicacion, categoria
- **Repositorio**: `LibroRepository` extiende `JpaRepository`
- **DTOs**: `LibroRequestDTO` y `LibroResponseDTO` para transferencia de datos
- **Mapper**: `LibroMapper` para convertir entre entidad y DTOs
- **Servicio**: `LibroService` con métodos para guardar, buscar por ID y listar todos
- **Controlador**: `LibroController` con endpoints GET y POST
- **Documentación**: Swagger/OpenAPI integrado
- **Excepciones**: `GlobalExceptionHandler` para manejo de errores

## Tecnologías Utilizadas

- Java 17
- Spring Boot 3.2.0
- Spring Data JPA
- H2 Database (en memoria)
- Lombok
- SpringDoc OpenAPI
- Jakarta Validation

## Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── biblioteca/
│   │           ├── BibliotecaApplication.java
│   │           ├── controller/
│   │           │   └── LibroController.java
│   │           ├── dto/
│   │           │   ├── LibroRequestDTO.java
│   │           │   └── LibroResponseDTO.java
│   │           ├── exception/
│   │           │   └── GlobalExceptionHandler.java
│   │           ├── mapper/
│   │           │   └── LibroMapper.java
│   │           ├── model/
│   │           │   └── Libro.java
│   │           ├── repository/
│   │           │   └── LibroRepository.java
│   │           └── service/
│   │               └── LibroService.java
│   └── resources/
│       └── application.properties
```

## Endpoints de la API

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/api/libros` | Crear un nuevo libro |
| GET | `/api/libros/{id}` | Obtener un libro por ID |
| GET | `/api/libros` | Listar todos los libros |

## Cómo Ejecutar

1. Asegúrate de tener Java 17 y Maven instalados
2. Ejecuta el proyecto:
   ```bash
   mvn spring-boot:run
   ```
3. Accede a Swagger UI: http://localhost:8080/swagger-ui.html
4. Accede a la consola H2: http://localhost:8080/h2-console
   - JDBC URL: `jdbc:h2:mem:biblioteca`
   - Username: `sa`
   - Password: (vacío)

## Capturas de Pantalla

### Swagger UI - Lista de Endpoints
[Agregar captura de pantalla aquí]

### Swagger UI - Crear Libro
[Agregar captura de pantalla aquí]

### Swagger UI - Respuesta de Libro Creado
[Agregar captura de pantalla aquí]

### Consola H2 - Tabla de Libros
[Agregar captura de pantalla aquí]

## Rúbrica de Evaluación

| Criterio | Descripción | Peso |
|----------|-------------|------|
| Implementación JPA | Uso correcto de anotaciones JPA, repositorio y configuración de H2 | 40% |
| Arquitectura DTO/Mapper | Separación clara entre entidad y DTOs | 20% |
| Manejo de Excepciones | Controlador global con códigos HTTP correctos (400, 404) | 15% |
| Funcionalidad y Swagger | API funcional con documentación | 15% |
| Entregables (GitHub) | Repositorio público con README y capturas | 10% |

## Autor

[Tu Nombre Completo]

## Licencia

MIT