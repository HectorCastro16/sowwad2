package com.clases.springboot.app.service;

import java.util.List;

import com.clases.springboot.app.model.entCategoriaEvento;

public interface ICategoriaEvento {
	public List<entCategoriaEvento> Listar() throws Exception;
	public entCategoriaEvento Recuperar(int id) throws Exception;
	public entCategoriaEvento Insertar(entCategoriaEvento te) throws Exception;
	public entCategoriaEvento Actualizar(entCategoriaEvento te) throws Exception;
	public entCategoriaEvento Eliminar(int id) throws Exception;
}
