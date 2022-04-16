package com.pelicula.peliculas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pelicula.peliculas.entity.Categoria;

@Repository
public interface CategorizeRepository extends CrudRepository<Categoria, Integer>{

}
