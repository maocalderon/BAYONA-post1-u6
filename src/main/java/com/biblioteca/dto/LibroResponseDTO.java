package com.biblioteca.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para la respuesta de un libro.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO para la respuesta de un libro")
public class LibroResponseDTO {
    
    @Schema(description = "ID único del libro", example = "1")
    private Long id;
    
    @Schema(description = "Título del libro", example = "Cien años de soledad")
    private String titulo;
    
    @Schema(description = "Autor del libro", example = "Gabriel García Márquez")
    private String autor;
    
    @Schema(description = "ISBN del libro", example = "978-0060934567")
    private String isbn;
    
    @Schema(description = "Año de publicación", example = "1967")
    private Integer anioPublicacion;
    
    @Schema(description = "Categoría del libro", example = "Novela")
    private String categoria;
}