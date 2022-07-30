package com.pelicula.peliculas.controllers;

import com.pelicula.peliculas.dao.UserDataLogin;
import com.pelicula.peliculas.entity.*;
import com.pelicula.peliculas.repository.UsuarioRepository;
import com.pelicula.peliculas.utils.Encript;

import com.pelicula.peliculas.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
public class ControllerUsuario {

    @Autowired
    UsuarioRepository r;

    @Autowired
    private JWTUtil jwtUtil;
    @CrossOrigin(origins ="http://192.168.0.24:8080/")
    @RequestMapping(value = "/login",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResponseEntity<TokenUser> login(@RequestBody UserDataLogin usuarioIn){

        Usuario usuario1;
        TokenUser tokenUser = new TokenUser();
        try {

            usuario1=r.findByUsuario(usuarioIn.getUsuario());
            System.out.println(usuario1.getIdUsuario()+"encontrado");
            Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
            char[] passChar = usuarioIn.getPassword().toCharArray();
            boolean esTrue=argon2.verify(usuario1.getPassword(),passChar);
            if (esTrue){
                System.out.println("encontrado");
                //tokenUser.setUser(usuario1.getUsuario());
                String token=jwtUtil.create(usuario1.getIdUsuario().toString(),usuario1.getUsuario());

                System.out.println(usuario1.getPassword()+"Encontrado");
                System.out.println(usuario1.getIdUsuario());
                //String token = getJWTToken(usuario1.getUsuario());
                tokenUser.setUser(usuario1.getUsuario());
                tokenUser.setToken(token);

            }else {
                return new ResponseEntity("Usuario no encontrado", HttpStatus.valueOf(200));
            }


        }
        catch (Exception e){
            return new ResponseEntity("Error"+e.getMessage(), HttpStatus.valueOf(400));
        }

        return  ResponseEntity.ok(tokenUser);
    }

    @RequestMapping(value = "/insertUser",method =RequestMethod.POST,produces ="application/json;charset=UTF-8")
    public ResponseEntity<Usuario>save(@RequestBody Usuario usuario){
        Usuario usuarioReg;
        Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        char[] vowelArray = usuario.getPassword().toCharArray();
        String resulHas=argon2.hash(1,1024,1,vowelArray);
        try {
            usuario.setPassword(resulHas);
            usuarioReg=r.save(usuario);
        }catch (Exception e){
            return new ResponseEntity("Error"+e.getMessage(), HttpStatus.valueOf(400));
        }
        return  ResponseEntity.ok(usuarioReg);
    }
    private String getJWTToken(String username) {
      /*String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
*/
        return null;
    }
}
