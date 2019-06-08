package com.clases.springboot.app.service;

import com.clases.springboot.app.model.entEvento;

public interface IEvento {
	public Integer EventoInsUpdDel(entEvento u, Integer TipoEdicion) throws Exception;
}
