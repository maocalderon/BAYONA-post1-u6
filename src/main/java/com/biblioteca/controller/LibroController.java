package com.biblioteca.controller;

import com.biblioteca.dto.LibroRequestDTO;
import com.biblioteca.dto.LibroResponseDTO;
import com.biblioteca.service.LibroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar libros.
 */
@RestController
@RequestMapping("/api/libros")
@Tag(name = "Libros", description = "API para gestionar libros de la biblioteca")
public class LibroController {
    
    private final LibroService libroService;
    
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }
    
    /**
     * Endpoint para crear un nuevo libro.
     * @param requestDTO Datos del libro a crear
     * @return El libro creado con código de estado 201 (Created)
     */
    @PostMapping
    @Operation(summary = "Crear un nuevo libro", description = "Crea un nuevo libro en la biblioteca")
    public ResponseEntity<LibroResponseDTO> crearLibro(@Valid @RequestBody LibroRequestDTO requestDTO) {
        LibroResponseDTO libroCreado = libroService.guardarLibro(requestDTO);
        return new ResponseEntity<>(libroCreado, HttpStatus.CREATED);
    }
    
    /**
     * Endpoint para obtener un libro por su ID.
     * @param id ID del libro a buscar
     * @return El libro encontrado con código de estado 200 (OK)
     */
    @GetMapping("/{id}")
    @Operation(summary = "Obtener libro por ID", description = "Retorna un libro específico según su ID")
    public ResponseEntity<LibroResponseDTO> obtenerLibroPorId(@PathVariable Long id) {
        LibroResponseDTO libro = libroService.buscarPorId(id);
        return ResponseEntity.ok(libro);
    }
    
    /**
     * Endpoint para listar todos los libros.
     * @return Lista de todos los libros con código de estado 200 (OK)
     */
    @GetMapping
    @Operation(summary = "Listar todos los libros", description = "Retorna todos los libros de la biblioteca")
    public ResponseEntity<List<LibroResponseDTO>> listarTodosLosLibros() {
        List<LibroResponseDTO> libros = libroService.listarTodos();
        return ResponseEntity.ok(libros);
    }
}