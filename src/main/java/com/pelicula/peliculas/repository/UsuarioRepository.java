package com.pelicula.peliculas.repository;

import com.pelicula.peliculas.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    @Query(value = "SELECT * FROM usuario u WHERE u.usuario = :usuario AND u.password=pgp_sym_encrypt(:pass, '7381@3', 'compress-algo=1, cipher-algo=aes128') LIMIT 1",nativeQuery = true)
    Usuario findByUsuarioAndPassword(@Param("usuario") String usuario, @Param("pass") String password);

    @Query(value = "SELECT * FROM usuario u WHERE u.usuario = :usuario LIMIT 1",nativeQuery = true)
    Usuario findByUsuario(@Param("usuario") String usuario);

}
