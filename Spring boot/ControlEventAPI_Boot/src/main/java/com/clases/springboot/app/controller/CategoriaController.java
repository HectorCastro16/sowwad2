package com.clases.springboot.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.clases.springboot.app.dao.CategoriaEventoDao;
import com.clases.springboot.app.model.entCategoriaEvento;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
//@CrossOrigin(origins = "https://control-event-client.azurewebsites.net", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping(value = "/api/cateve", produces = { MediaType.APPLICATION_JSON_VALUE })

public class CategoriaController {
	
	@GetMapping(value = "/listCatEve")
	public ResponseEntity<List<entCategoriaEvento>> getCatEvens(){			
		try {
			List<entCategoriaEvento> list = CategoriaEventoDao.Instancia().Listar();
			if(list.size() > 0 && list!=null) {
				return new ResponseEntity<List<entCategoriaEvento>>(list, HttpStatus.OK) ;
			}
		} catch (Exception e) {
			System.out.print("getCatEvens: "+e.getMessage()+ "\n");
		}			
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value = "/buscarCatEve/{id}")
	public ResponseEntity<entCategoriaEvento> getCatEve(@PathVariable("id") int id){			
		try {
			entCategoriaEvento res = CategoriaEventoDao.Instancia().Recuperar(id);
			if(res != null) {
				return new ResponseEntity<entCategoriaEvento>(res,HttpStatus.OK);
			}
		} catch (Exception e) {
			System.out.print("getCatEve: "+e.getMessage()+"\n");
		}		
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
		
	@PostMapping(value = "/insertarCatEve")
	public ResponseEntity<entCategoriaEvento> addCatEve(@RequestBody entCategoriaEvento te){
		try {	
			entCategoriaEvento res = CategoriaEventoDao.Instancia().Insertar(te);
			if(res != null) {
				return new ResponseEntity<entCategoriaEvento>(res,HttpStatus.OK);			
			}
		} catch (Exception e) {
			System.out.print("error addCatEve :"+e.getMessage()+"\n");
		}	
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "/actualizaCatEve")
	public ResponseEntity<entCategoriaEvento> updCatEve(@RequestBody entCategoriaEvento te){		
		try {
			entCategoriaEvento res = CategoriaEventoDao.Instancia().Actualizar(te);
			if(res != null) {
				return new ResponseEntity<entCategoriaEvento>(res,HttpStatus.OK);			
			}
		} catch (Exception e) {
			System.out.print("updCatEve: "+e.getMessage()+"\n");			
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "/eliminarCatEve/{id}")
	public ResponseEntity<entCategoriaEvento> deleteCatEve(@PathVariable("id") int id){		
		try {
			entCategoriaEvento res = CategoriaEventoDao.Instancia().Eliminar(id);
			if(res != null) {
				return new ResponseEntity<entCategoriaEvento>(res,HttpStatus.OK);			
			}
		} catch (Exception e) {
			System.out.print("deleteCatEve: "+e.getMessage()+"\n");			
		}	
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

}
