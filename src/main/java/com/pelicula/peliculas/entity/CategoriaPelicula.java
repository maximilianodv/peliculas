package com.pelicula.peliculas.entity;


import lombok.Data;

import javax.persistence.*;


@Entity(name = "CategoriaPelicula")
@Table(name = "categoria_pelicula")
@Data
public class CategoriaPelicula {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name="id_cat_pelicula")
    private long idCategoriaPelicula;

    @ManyToOne(cascade = CascadeType.ALL,targetEntity=Pelicula.class)
    @JoinColumn(name="id_pelicula",referencedColumnName = "id_pelicula")
    private Pelicula pelicula;

    @ManyToOne(fetch =FetchType.LAZY,cascade = CascadeType.ALL,targetEntity=Categoria.class)
    @JoinColumn(name="id_categoria",referencedColumnName = "id_categoria")
//    private List<Categoria> categorias =new ArrayList<Categoria>();
    private Categoria categorias;
    
    
}
