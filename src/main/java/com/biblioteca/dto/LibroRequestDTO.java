package com.biblioteca.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para solicitar la creación o actualización de un libro.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO para solicitar datos de un libro")
public class LibroRequestDTO {
    
    @NotBlank(message = "El título es obligatorio")
    @Schema(description = "Título del libro", example = "Cien años de soledad")
    private String titulo;
    
    @NotBlank(message = "El autor es obligatorio")
    @Schema(description = "Autor del libro", example = "Gabriel García Márquez")
    private String autor;
    
    @NotBlank(message = "El ISBN es obligatorio")
    @Schema(description = "ISBN del libro", example = "978-0060934567")
    private String isbn;
    
    @Min(value = 1000, message = "El año de publicación debe ser mayor o igual a 1000")
    @Max(value = 2026, message = "El año de publicación no puede ser mayor a 2026")
    @Schema(description = "Año de publicación", example = "1967")
    private Integer anioPublicacion;
    
    @Schema(description = "Categoría del libro", example = "Novela")
    private String categoria;
}