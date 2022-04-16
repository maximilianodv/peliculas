package com.pelicula.peliculas.repository;

import com.pelicula.peliculas.entity.Pelicula;
import org.springframework.data.repository.CrudRepository;

public interface PeliculaRepository extends CrudRepository<Pelicula, Integer> {
}
