package com.pelicula.peliculas.entity;


import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Categoria")
@Table(name = "categoria")
@Data
public class Categoria {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id_categoria")
	private Integer idCategoria;

	@Column(name="nombre")
	private String nombre;

	@Override
	public String toString() {
		return "Categoria{" +
				"idCategoria=" + idCategoria +
				", nombre='" + nombre + '\'' +
				'}';
	}
}
