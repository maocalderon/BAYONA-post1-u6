package com.biblioteca.mapper;

import com.biblioteca.dto.LibroRequestDTO;
import com.biblioteca.dto.LibroResponseDTO;
import com.biblioteca.model.Libro;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Mapper para convertir entre la entidad Libro y los DTOs.
 */
@Component
public class LibroMapper {
    
    /**
     * Convierte un LibroRequestDTO a entidad Libro.
     */
    public Libro toEntity(LibroRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Libro libro = new Libro();
        libro.setTitulo(dto.getTitulo());
        libro.setAutor(dto.getAutor());
        libro.setIsbn(dto.getIsbn());
        libro.setAnioPublicacion(dto.getAnioPublicacion());
        libro.setCategoria(dto.getCategoria());
        
        return libro;
    }
    
    /**
     * Convierte una entidad Libro a LibroResponseDTO.
     */
    public LibroResponseDTO toDTO(Libro libro) {
        if (libro == null) {
            return null;
        }
        
        return new LibroResponseDTO(
            libro.getId(),
            libro.getTitulo(),
            libro.getAutor(),
            libro.getIsbn(),
            libro.getAnioPublicacion(),
            libro.getCategoria()
        );
    }
    
    /**
     * Convierte una lista de entidades Libro a una lista de LibroResponseDTO.
     */
    public List<LibroResponseDTO> toDTOList(List<Libro> libros) {
        if (libros == null) {
            return null;
        }
        
        return libros.stream()
                .map(this::toDTO)
                .toList();
    }
}