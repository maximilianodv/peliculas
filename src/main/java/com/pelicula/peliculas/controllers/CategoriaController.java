package com.pelicula.peliculas.controllers;

import com.pelicula.peliculas.entity.Categoria;
import com.pelicula.peliculas.repository.CategorizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
@Autowired
CategorizeRepository r;

@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
public ResponseEntity<Categoria> save(@RequestBody Categoria categoria){
	Categoria cat= r.save(categoria);
	return  cat!=null?ResponseEntity.ok(cat):(ResponseEntity) ResponseEntity.badRequest();
}
@RequestMapping(value = "/delete", method = RequestMethod.DELETE,produces = "application/json;charset=UTF-8")
public ResponseEntity<String> deleteId(@PathParam("id_categoria") Integer id_categoria){
	try {
		r.deleteById(id_categoria);
		return ResponseEntity.ok(id_categoria+" Eliminado");
	}
	catch (Exception e){
		return  new ResponseEntity("Error"+e.getMessage(), HttpStatus.valueOf(400));
	}
}

}
