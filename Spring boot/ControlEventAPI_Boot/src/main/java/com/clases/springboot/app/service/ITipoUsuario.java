package com.clases.springboot.app.service;

import java.util.List;

import com.clases.springboot.app.model.entTipoUsuario;

public interface ITipoUsuario {
	public List<entTipoUsuario> Listar() throws Exception;
	public entTipoUsuario Recuperar(int id) throws Exception;
	public entTipoUsuario Insertar(entTipoUsuario te) throws Exception;
	public entTipoUsuario Actualizar(entTipoUsuario te) throws Exception;
	public entTipoUsuario Eliminar(int id) throws Exception;

}
