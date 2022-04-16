package com.pelicula.peliculas.controllers;

import com.pelicula.peliculas.entity.Categoria;
import com.pelicula.peliculas.entity.CategoriaPelicula;
import com.pelicula.peliculas.entity.Pelicula;
import com.pelicula.peliculas.entity.PeliculaCategoriasList;
import com.pelicula.peliculas.repository.CategoriaPeliculaRepository;
import com.pelicula.peliculas.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pelicula.peliculas.repository.CategorizeRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pelicula")
public class ControllerPeliculas {

    @Autowired
    private PlatformTransactionManager transactionManager;

	@Autowired
    PeliculaRepository pr;
    @Autowired
    CategoriaPeliculaRepository catPelRp;

    @Autowired
    CategorizeRepository catRep;

    @RequestMapping(value = "/save",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResponseEntity<CategoriaPelicula> save(@RequestBody CategoriaPelicula catpelicula){
//        TransactionStatus transaction = this.transactionManager.getTransaction(null);
        try {
          

        	catPelRp.save(catpelicula);
            //this.transactionManager.commit(transaction);
        }
        catch (Exception e){
            return new ResponseEntity("Error"+e.getMessage(),HttpStatus.valueOf(400));
        }
        return  ResponseEntity.ok(catpelicula);
    }


    @RequestMapping(value = "/update",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResponseEntity<PeliculaCategoriasList> update(@RequestBody PeliculaCategoriasList update){
        Pelicula newP=update.getPelicula();

        return  ResponseEntity.ok(update);
    }


    @RequestMapping(value="/delete",method = RequestMethod.DELETE,produces ="application/json;charset=UTF-8")
    public ResponseEntity<Pelicula> delete(@RequestBody Pelicula pelicula){
        try {
            pr.delete(pelicula);
        }catch (Exception e){
            return new ResponseEntity("Error"+e.getMessage(),HttpStatus.valueOf(400));
        }
        return  ResponseEntity.ok(pelicula);
    }
}
