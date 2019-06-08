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

import com.clases.springboot.app.dao.RequerimientoDao;
import com.clases.springboot.app.model.entRequerimiento;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
//@CrossOrigin(origins = "https://control-event-client.azurewebsites.net", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping(value = "/api/req", produces = { MediaType.APPLICATION_JSON_VALUE })

public class RequerimientoController {
	///
	@PostMapping(value = "/crudReq/{tipEdicion}")
	public ResponseEntity<Integer> crudReq(@RequestBody entRequerimiento u,@PathVariable("tipEdicion") Integer TipoEdicion){
		try {
			Integer res = RequerimientoDao.Instancia().RequerimientoInsUpdDel(u, TipoEdicion);
			if(res > 0) {
				return new ResponseEntity<Integer>(res,HttpStatus.OK);
			}
		} catch (Exception e) {
			System.out.print("error crudEve :"+e.getMessage()+"\n");
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
