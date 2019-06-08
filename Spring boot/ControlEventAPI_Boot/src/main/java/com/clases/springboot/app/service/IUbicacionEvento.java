package com.clases.springboot.app.service;

import com.clases.springboot.app.model.entUbicacionEvento;

public interface IUbicacionEvento {
	public entUbicacionEvento Recuperar(int id) throws Exception;
	public entUbicacionEvento Insertar(entUbicacionEvento te) throws Exception;
	
}
