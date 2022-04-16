package com.pelicula.peliculas.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "CategoriaPelicula")
@Table(name = "categoria_pelicula")
public class CategoriaPelicula {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name="id_cat_pelicula")
    private long idCategoriaPelicula;

    @ManyToOne(cascade = CascadeType.ALL,targetEntity=Pelicula.class)
    @JoinColumn(name="id_pelicula")
    private Pelicula pelicula;

    @ManyToOne(fetch =FetchType.LAZY,cascade = CascadeType.ALL,targetEntity=Categoria.class)
    @JoinColumn(name="id_categoria",nullable = false)
    private List<Categoria> categorias;

	public long getIdCategoriaPelicula() {
		return idCategoriaPelicula;
	}

	public void setIdCategoriaPelicula(long idCategoriaPelicula) {
		this.idCategoriaPelicula = idCategoriaPelicula;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
    
   
}
