package com.biblioteca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad Libro que representa la tabla de libros en la base de datos H2.
 */
@Entity
@Table(name = "libros")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 200)
    private String titulo;
    
    @Column(nullable = false, length = 100)
    private String autor;
    
    @Column(nullable = false, unique = true, length = 13)
    private String isbn;
    
    @Column(name = "anio_publicacion")
    private Integer anioPublicacion;
    
    @Column(length = 50)
    private String categoria;
}