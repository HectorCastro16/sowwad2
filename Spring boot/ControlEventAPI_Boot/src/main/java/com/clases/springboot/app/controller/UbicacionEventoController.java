package com.clases.springboot.app.controller;

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

import com.clases.springboot.app.dao.UbicacionEventoDao;
import com.clases.springboot.app.model.entUbicacionEvento;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
//@CrossOrigin(origins = "https://control-event-client.azurewebsites.net", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping(value = "/api/ubi", produces = { MediaType.APPLICATION_JSON_VALUE })

public class UbicacionEventoController {

	@GetMapping(value = "/buscarUbi/{id}")
	public ResponseEntity<entUbicacionEvento> getUbicacion(@PathVariable("id") int id){			
		try {
			entUbicacionEvento res = UbicacionEventoDao.Instancia().Recuperar(id);
			if(res != null) {
				return new ResponseEntity<entUbicacionEvento>(res,HttpStatus.OK);
			}
		} catch (Exception e) {
			System.out.print("getTipEve: "+e.getMessage()+"\n");
		}		
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
		
	@PostMapping(value = "/insertarUbi")
	public ResponseEntity<entUbicacionEvento> addUbicacion(@RequestBody entUbicacionEvento te){
		try {	
			entUbicacionEvento res = UbicacionEventoDao.Instancia().Insertar(te);
			if(res != null) {
				return new ResponseEntity<entUbicacionEvento>(res,HttpStatus.OK);			
			}
			//return new ResponseEntity<entTipoEvento>(TipoEventoDao.Instancia().Insertar(te),HttpStatus.OK);
		} catch (Exception e) {
			System.out.print("error addCatEve :"+e.getMessage()+"\n");
		}	
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
