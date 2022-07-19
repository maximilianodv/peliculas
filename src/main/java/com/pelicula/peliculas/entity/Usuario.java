package com.pelicula.peliculas.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Usuario")
@Table(name = "usuario")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name="id_usuario")
    private Integer idUsuario;

    @Column(name="nombre")
    private String nombre;

    @Column(name="usuario")
    private String usuario;

    @Column(name="password")
    private String password;

    @Column(name="fecha_alta")
    private Date fechaAlta;

    @Column(name="fecha_baja")
    private Date fechaBaja;

    @Column(name="fecha_actualizacion")
    private Date fechaActualizacion;

    @Column(name="status")
    private boolean status;

}
