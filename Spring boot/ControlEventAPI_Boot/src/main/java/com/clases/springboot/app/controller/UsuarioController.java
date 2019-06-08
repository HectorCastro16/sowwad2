package com.clases.springboot.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.clases.springboot.app.dao.UsuarioDao;
import com.clases.springboot.app.model.entUsuario;
import com.clases.springboot.app.model.entUsuarioRequest;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
//@CrossOrigin(origins = "https://control-event-client.azurewebsites.net", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping(value = "/api/usu", produces = { MediaType.APPLICATION_JSON_VALUE })

public class UsuarioController {
	
	@PostMapping(value = "/crudUsu/{tipEdicion}")
	public ResponseEntity<Integer> crudUsu(@RequestBody entUsuario u,@PathVariable("tipEdicion") Integer TipoEdicion){
		try {
			Integer res = UsuarioDao.Instancia().UserInsUpdDelBlo(u, TipoEdicion);
			if(res > 0) {
				return new ResponseEntity<Integer>(res,HttpStatus.OK);
			}
		} catch (Exception e) {
			System.out.print("error crudUsu :"+e.getMessage()+"\n");
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "/verificaAcceso")
	public ResponseEntity<entUsuario> Acceso(@RequestBody entUsuarioRequest u){
		try {
			entUsuario res = UsuarioDao.Instancia().VerificarAccesoIntranet(u.getLogin(), u.getClave());
			if(res != null) {
				return new ResponseEntity<entUsuario>(res,HttpStatus.OK);
			}
		} catch (Exception e) {
			System.out.print("error Acceso :"+e.getMessage()+"\n");
		}
		return new ResponseEntity("Error user o password incorrectos",HttpStatus.NOT_FOUND);
	}
}

