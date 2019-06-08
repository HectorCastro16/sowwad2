package com.clases.springboot.app.service;

import java.util.List;

import com.clases.springboot.app.model.entTipoEvento;

public interface ITipoEvento {
	public List<entTipoEvento> Listar() throws Exception;
	public entTipoEvento Recuperar(int id) throws Exception;
	public entTipoEvento Insertar(entTipoEvento te) throws Exception;
	public entTipoEvento Actualizar(entTipoEvento te) throws Exception;
	public entTipoEvento Eliminar(int id) throws Exception;
}
