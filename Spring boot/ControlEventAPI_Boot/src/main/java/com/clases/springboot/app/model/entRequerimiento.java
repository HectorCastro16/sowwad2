package com.clases.springboot.app.model;

import java.util.Date;

public class entRequerimiento {
	private Integer req_Id;
    private entEvento evento;
    private String req_Codigo;
    private Date req_Fecha_Inicio;
    private Date req_Fecha_Fin;
    private Boolean req_Estado;
    private String req_Observaciones;
    private entUsuario usu_Solicitante;
    private entUsuario usu_Asignado;
	public Integer getReq_Id() {
		return req_Id;
	}
	public void setReq_Id(Integer req_Id) {
		this.req_Id = req_Id;
	}
	public entEvento getEvento() {
		return evento;
	}
	public void setEvento(entEvento evento) {
		this.evento = evento;
	}
	public String getReq_Codigo() {
		return req_Codigo;
	}
	public void setReq_Codigo(String req_Codigo) {
		this.req_Codigo = req_Codigo;
	}
	public Date getReq_Fecha_Inicio() {
		return req_Fecha_Inicio;
	}
	public void setReq_Fecha_Inicio(Date req_Fecha_Inicio) {
		this.req_Fecha_Inicio = req_Fecha_Inicio;
	}
	public Date getReq_Fecha_Fin() {
		return req_Fecha_Fin;
	}
	public void setReq_Fecha_Fin(Date req_Fecha_Fin) {
		this.req_Fecha_Fin = req_Fecha_Fin;
	}
	public Boolean getReq_Estado() {
		return req_Estado;
	}
	public void setReq_Estado(Boolean req_Estado) {
		this.req_Estado = req_Estado;
	}
	public String getReq_Observaciones() {
		return req_Observaciones;
	}
	public void setReq_Observaciones(String req_Observaciones) {
		this.req_Observaciones = req_Observaciones;
	}
	public entUsuario getUsu_Solicitante() {
		return usu_Solicitante;
	}
	public void setUsu_Solicitante(entUsuario usu_Solicitante) {
		this.usu_Solicitante = usu_Solicitante;
	}
	public entUsuario getUsu_Asignado() {
		return usu_Asignado;
	}
	public void setUsu_Asignado(entUsuario usu_Asignado) {
		this.usu_Asignado = usu_Asignado;
	} 
    
    
}
