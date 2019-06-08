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

import com.clases.springboot.app.dao.ModalidadEventoDao;
import com.clases.springboot.app.model.entModalidadEvento;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
//@CrossOrigin(origins = "https://control-event-client.azurewebsites.net", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping(value = "/api/modeve", produces = { MediaType.APPLICATION_JSON_VALUE })


public class ModalidadController {
	
	@GetMapping(value = "/listModalidad")
	public ResponseEntity<List<entModalidadEvento>> getModalidad(){			
		try {
			List<entModalidadEvento> list = ModalidadEventoDao.Instancia().Listar();
			if(list.size() > 0 && list!=null) {
				return new ResponseEntity<List<entModalidadEvento>>(list, HttpStatus.OK) ;
			}
		} catch (Exception e) {
			System.out.print("getModalidad: "+e.getMessage()+ "\n");
		}			
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value = "/buscarModalidad/{id}")
	public ResponseEntity<entModalidadEvento> getModalidad(@PathVariable("id") int id){			
		try {
			entModalidadEvento res = ModalidadEventoDao.Instancia().Recuperar(id);
			if(res != null) {
				return new ResponseEntity<entModalidadEvento>(res,HttpStatus.OK);
			}
		} catch (Exception e) {
			System.out.print("getModalidad: "+e.getMessage()+"\n");
		}		
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
		
	@PostMapping(value = "/insertarModalidad")
	public ResponseEntity<entModalidadEvento> addModalidad(@RequestBody entModalidadEvento te){
		try {	
			entModalidadEvento res = ModalidadEventoDao.Instancia().Insertar(te);
			if(res != null) {
				return new ResponseEntity<entModalidadEvento>(res,HttpStatus.OK);			
			}
		} catch (Exception e) {
			System.out.print("error addModalidad :"+e.getMessage()+"\n");
		}	
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "/actualizaModalidad")
	public ResponseEntity<entModalidadEvento> updModalidad(@RequestBody entModalidadEvento te){		
		try {
			entModalidadEvento res = ModalidadEventoDao.Instancia().Actualizar(te);
			if(res != null) {
				return new ResponseEntity<entModalidadEvento>(res,HttpStatus.OK);			
			}
		} catch (Exception e) {
			System.out.print("updModalidad: "+e.getMessage()+"\n");			
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "/eliminarModalidad/{id}")
	public ResponseEntity<entModalidadEvento> deleteModalidad(@PathVariable("id") int id){		
		try {
			entModalidadEvento res = ModalidadEventoDao.Instancia().Eliminar(id);
			if(res != null) {
				return new ResponseEntity<entModalidadEvento>(res,HttpStatus.OK);			
			}
		} catch (Exception e) {
			System.out.print("deleteModalidad: "+e.getMessage()+"\n");			
		}	
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
