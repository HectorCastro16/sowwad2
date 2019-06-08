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

import com.clases.springboot.app.dao.TipoUsuarioDao;
import com.clases.springboot.app.model.entTipoUsuario;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
//@CrossOrigin(origins = "https://control-event-client.azurewebsites.net", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping(value = "/api/tipusu", produces = { MediaType.APPLICATION_JSON_VALUE })

public class TipoUsuarioController {
	@GetMapping(value = "/listTipUsu")
	public ResponseEntity<List<entTipoUsuario>> getTipUsu(){			
		try {
			List<entTipoUsuario> list = TipoUsuarioDao.Instancia().Listar();
			if(list.size() > 0 && list!=null) {
				return new ResponseEntity<List<entTipoUsuario>>(list, HttpStatus.OK) ;
			}
		} catch (Exception e) {
			System.out.print("getTipUsu: "+e.getMessage()+ "\n");
		}			
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value = "/buscarTipUsu/{id}")
	public ResponseEntity<entTipoUsuario> getTipUsu(@PathVariable("id") int id){			
		try {
			entTipoUsuario res = TipoUsuarioDao.Instancia().Recuperar(id);
			if(res != null) {
				return new ResponseEntity<entTipoUsuario>(res,HttpStatus.OK);
			}
		} catch (Exception e) {
			System.out.print("getTipUsu: "+e.getMessage()+"\n");
		}		
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
		
	@PostMapping(value = "/insertarTipUsu")
	public ResponseEntity<entTipoUsuario> addTipUsu(@RequestBody entTipoUsuario te){
		try {	
			entTipoUsuario res = TipoUsuarioDao.Instancia().Insertar(te);
			if(res != null) {
				return new ResponseEntity<entTipoUsuario>(res,HttpStatus.OK);			
			}
		} catch (Exception e) {
			System.out.print("error addTipUsu :"+e.getMessage()+"\n");
		}	
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "/actualizaTipUsu")
	public ResponseEntity<entTipoUsuario> updTipUsu(@RequestBody entTipoUsuario te){		
		try {
			entTipoUsuario res = TipoUsuarioDao.Instancia().Actualizar(te);
			if(res != null) {
				return new ResponseEntity<entTipoUsuario>(res,HttpStatus.OK);			
			}
		} catch (Exception e) {
			System.out.print("updTipUsu: "+e.getMessage()+"\n");			
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "/eliminarTipUsu/{id}")
	public ResponseEntity<entTipoUsuario> deleteTipUsu(@PathVariable("id") int id){		
		try {
			entTipoUsuario res = TipoUsuarioDao.Instancia().Eliminar(id);
			if(res != null) {
				return new ResponseEntity<entTipoUsuario>(res,HttpStatus.OK);			
			}
		} catch (Exception e) {
			System.out.print("deleteTipUsu: "+e.getMessage()+"\n");			
		}	
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
