package com.pelicula.peliculas.entity;

import lombok.Data;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
@Data
public class PeliculaCategoriasList {
    private Pelicula pelicula;
    private List<Categoria> categoria=new ArrayList<Categoria>();

    @Override
    public String toString() {
        return "PeliculaCategoriasList{" +
                "pelicula=" + pelicula +
                ", categorias=" + categoria +
                '}';
    }
}
