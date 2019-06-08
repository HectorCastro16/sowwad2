package com.clases.springboot.app.model;

import java.util.Date;

public class entEvento {
	 private Integer eve_Id;
     private String eve_Codigo;
     private String eve_Link_Site_oficial;
     private String eve_Lugar;
     private String eve_Organizador;
     private Date eve_Fecha;
     private String eve_Hora;
     private Boolean eve_Visualizar;
     private String eve_Descripcion;
     private entCategoriaEvento categoriaEvento;
     private entTipoEvento tipoEvento;
     private entModalidadEvento modalidadEvento;
     private entUbicacionEvento ubicacionEvento;
	public Integer getEve_Id() {
		return eve_Id;
	}
	public void setEve_Id(Integer eve_Id) {
		this.eve_Id = eve_Id;
	}
	public String getEve_Codigo() {
		return eve_Codigo;
	}
	public void setEve_Codigo(String eve_Codigo) {
		this.eve_Codigo = eve_Codigo;
	}
	public String getEve_Link_Site_oficial() {
		return eve_Link_Site_oficial;
	}
	public void setEve_Link_Site_oficial(String eve_Link_Site_oficial) {
		this.eve_Link_Site_oficial = eve_Link_Site_oficial;
	}
	public String getEve_Lugar() {
		return eve_Lugar;
	}
	public void setEve_Lugar(String eve_Lugar) {
		this.eve_Lugar = eve_Lugar;
	}
	public String getEve_Organizador() {
		return eve_Organizador;
	}
	public void setEve_Organizador(String eve_Organizador) {
		this.eve_Organizador = eve_Organizador;
	}
	public Date getEve_Fecha() {
		return eve_Fecha;
	}
	public void setEve_Fecha(Date eve_Fecha) {
		this.eve_Fecha = eve_Fecha;
	}
	public String getEve_Hora() {
		return eve_Hora;
	}
	public void setEve_Hora(String eve_Hora) {
		this.eve_Hora = eve_Hora;
	}
	public Boolean getEve_Visualizar() {
		return eve_Visualizar;
	}
	public void setEve_Visualizar(Boolean eve_Visualizar) {
		this.eve_Visualizar = eve_Visualizar;
	}
	public String getEve_Descripcion() {
		return eve_Descripcion;
	}
	public void setEve_Descripcion(String eve_Descripcion) {
		this.eve_Descripcion = eve_Descripcion;
	}
	public entCategoriaEvento getCategoriaEvento() {
		return categoriaEvento;
	}
	public void setCategoriaEvento(entCategoriaEvento categoriaEvento) {
		this.categoriaEvento = categoriaEvento;
	}
	public entTipoEvento getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(entTipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	public entModalidadEvento getModalidadEvento() {
		return modalidadEvento;
	}
	public void setModalidadEvento(entModalidadEvento modalidadEvento) {
		this.modalidadEvento = modalidadEvento;
	}
	public entUbicacionEvento getUbicacionEvento() {
		return ubicacionEvento;
	}
	public void setUbicacionEvento(entUbicacionEvento ubicacionEvento) {
		this.ubicacionEvento = ubicacionEvento;
	}
     
     
}
