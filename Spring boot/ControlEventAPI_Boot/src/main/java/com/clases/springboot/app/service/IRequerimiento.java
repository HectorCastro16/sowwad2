package com.clases.springboot.app.service;

import com.clases.springboot.app.model.entRequerimiento;

public interface IRequerimiento {
	public Integer RequerimientoInsUpdDel(entRequerimiento u, Integer TipoEdicion) throws Exception;
}
