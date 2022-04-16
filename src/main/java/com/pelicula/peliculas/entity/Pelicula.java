package com.pelicula.peliculas.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "Pelicula")
@Table(name = "pelicula")
@Getter
@Setter
public class Pelicula {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name="id_pelicula")
    private Integer idPelicula;

    @Column(name="nombre")
    private String nombre;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="fechaAlta")
    private Date fechaAlta;

    @Column(name="fechaBaja")
    private Date fechaBaja;

    @Column(name="fechaModificacion")
    private Date fechaModificacion;

    @Column(name="status")
    private boolean status;

    @Column(name="caratula")
    private String caratula;

    @Column(name="pathVideo")
    private String pathVideo;

}
