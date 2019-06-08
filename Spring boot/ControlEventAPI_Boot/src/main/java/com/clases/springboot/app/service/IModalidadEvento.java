package com.clases.springboot.app.service;

import java.util.List;

import com.clases.springboot.app.model.entModalidadEvento;

public interface IModalidadEvento {
	public List<entModalidadEvento> Listar() throws Exception;
	public entModalidadEvento Recuperar(int id) throws Exception;
	public entModalidadEvento Insertar(entModalidadEvento te) throws Exception;
	public entModalidadEvento Actualizar(entModalidadEvento te) throws Exception;
	public entModalidadEvento Eliminar(int id) throws Exception;

}
