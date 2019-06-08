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

import com.clases.springboot.app.dao.TipoEventoDao;
import com.clases.springboot.app.dao.UsuarioDao;
import com.clases.springboot.app.model.entTipoEvento;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
//@CrossOrigin(origins = "https://control-event-client.azurewebsites.net", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping(value = "/api/tipeve", produces = { MediaType.APPLICATION_JSON_VALUE })


public class TipoEventoController {

	@GetMapping(value = "/listTipEve")
	public ResponseEntity<List<entTipoEvento>> getTipEvens(){			
		try {
			List<entTipoEvento> list = TipoEventoDao.Instancia().Listar();
			if(list.size() > 0 && list!=null) {
				return new ResponseEntity<List<entTipoEvento>>(list, HttpStatus.OK) ;
			}
		} catch (Exception e) {
			System.out.print("getTipEvens: "+e.getMessage()+ "\n");
		}			
		return new ResponseEntity(HttpStatus.NOT_FOUND);
		
		/*
		try {
			return new ResponseEntity<List<entTipoEvento>>(TipoEventoDao.Instancia().Listar(), HttpStatus.OK) ;
		} catch (Exception e) {
			System.out.print("getTipEvens: "+e.getMessage()+ "\n");
		}	
		return new ResponseEntity(HttpStatus.NOT_FOUND);
		*/
	}
	
	@GetMapping(value = "/buscarTipEve/{id}")
	public ResponseEntity<entTipoEvento> getTipEve(@PathVariable("id") int id){			
		try {
			entTipoEvento res = TipoEventoDao.Instancia().Recuperar(id);
			if(res != null) {
				return new ResponseEntity<entTipoEvento>(res,HttpStatus.OK);
			}
			//return new ResponseEntity<entTipoEvento>(TipoEventoDao.Instancia().Recuperar(id),HttpStatus.OK);
		} catch (Exception e) {
			System.out.print("getTipEve: "+e.getMessage()+"\n");
		}		
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
		
	@PostMapping(value = "/insertarTipEve")
	public ResponseEntity<entTipoEvento> addTipEve(@RequestBody entTipoEvento te){
		try {	
			entTipoEvento res = TipoEventoDao.Instancia().Insertar(te);
			if(res != null) {
				return new ResponseEntity<entTipoEvento>(res,HttpStatus.OK);			
			}
			//return new ResponseEntity<entTipoEvento>(TipoEventoDao.Instancia().Insertar(te),HttpStatus.OK);
		} catch (Exception e) {
			System.out.print("error addCatEve :"+e.getMessage()+"\n");
		}	
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "/actualizaTipEve")
	public ResponseEntity<entTipoEvento> updTipEve(@RequestBody entTipoEvento te){		
		try {
			entTipoEvento res = TipoEventoDao.Instancia().Actualizar(te);
			if(res != null) {
				return new ResponseEntity<entTipoEvento>(res,HttpStatus.OK);			
			}			
			//return new ResponseEntity<entTipoEvento>(TipoEventoDao.Instancia().Actualizar(te),HttpStatus.OK);
		} catch (Exception e) {
			System.out.print("updTipEve: "+e.getMessage()+"\n");			
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "/eliminarTipEve/{id}")
	public ResponseEntity<entTipoEvento> deleteTipEve(@PathVariable("id") int id){		
		try {
			entTipoEvento res = TipoEventoDao.Instancia().Eliminar(id);
			if(res != null) {
				return new ResponseEntity<entTipoEvento>(res,HttpStatus.OK);			
			}
			//return new ResponseEntity<entTipoEvento>(TipoEventoDao.Instancia().Eliminar(id),HttpStatus.OK);
		} catch (Exception e) {
			System.out.print("deleteTipEve: "+e.getMessage()+"\n");			
		}	
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
