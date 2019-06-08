package com.clases.springboot.app.service;

import com.clases.springboot.app.model.entUsuario;

public interface IUsuario {
	public Integer UserInsUpdDelBlo (entUsuario u, Integer TipoEdicion) throws Exception;
	public entUsuario VerificarAccesoIntranet (String prmstrLogin, String prmstrPassw) throws Exception;
}
