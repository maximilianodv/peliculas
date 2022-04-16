package com.pelicula.peliculas.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "Pelicula")
@Table(name = "pelicula")
@Data
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

	@Override
	public String toString() {
		return "Pelicula [idPelicula=" + idPelicula + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", fechaAlta=" + fechaAlta + ", fechaBaja=" + fechaBaja + ", fechaModificacion=" + fechaModificacion
				+ ", status=" + status + ", caratula=" + caratula + ", pathVideo=" + pathVideo + "]";
	}

}
