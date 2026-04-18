package com.biblioteca.service;

import com.biblioteca.dto.LibroRequestDTO;
import com.biblioteca.dto.LibroResponseDTO;
import com.biblioteca.mapper.LibroMapper;
import com.biblioteca.model.Libro;
import com.biblioteca.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Servicio para gestionar las operaciones de libros.
 */
@Service
public class LibroService {
    
    private final LibroRepository libroRepository;
    private final LibroMapper libroMapper;
    
    public LibroService(LibroRepository libroRepository, LibroMapper libroMapper) {
        this.libroRepository = libroRepository;
        this.libroMapper = libroMapper;
    }
    
    /**
     * Guarda un nuevo libro en la base de datos.
     * @param requestDTO Datos del libro a guardar
     * @return El libro guardado como DTO de respuesta
     */
    public LibroResponseDTO guardarLibro(LibroRequestDTO requestDTO) {
        Libro libro = libroMapper.toEntity(requestDTO);
        Libro libroGuardado = libroRepository.save(libro);
        return libroMapper.toDTO(libroGuardado);
    }
    
    /**
     * Busca un libro por su ID.
     * @param id ID del libro a buscar
     * @return El libro encontrado como DTO de respuesta
     * @throws NoSuchElementException Si no se encuentra el libro
     */
    public LibroResponseDTO buscarPorId(Long id) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Libro no encontrado con ID: " + id));
        return libroMapper.toDTO(libro);
    }
    
    /**
     * Lista todos los libros existentes.
     * @return Lista de libros como DTOs de respuesta
     */
    public List<LibroResponseDTO> listarTodos() {
        List<Libro> libros = libroRepository.findAll();
        return libroMapper.toDTOList(libros);
    }
}