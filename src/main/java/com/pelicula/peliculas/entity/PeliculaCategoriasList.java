package com.pelicula.peliculas.entity;

import java.util.List;

public class PeliculaCategoriasList {
    private Pelicula pelicula;
    private List<Categoria> categorias;

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategoria(List<Categoria> categoria) {
        this.categorias = categoria;
    }

    @Override
    public String toString() {
        return "PeliculaCategoriasList{" +
                "pelicula=" + pelicula +
                ", categoria=" + categorias +
                '}';
    }
}
