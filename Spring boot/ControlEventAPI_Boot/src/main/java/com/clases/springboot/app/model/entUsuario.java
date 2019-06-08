package com.clases.springboot.app.model;

import java.util.Date;

public class entUsuario {

	private Integer usu_Id;
    private String usu_Codigo;
    private entPersona persona;
    private entTipoUsuario tipo_Usuario;
    private String usu_Login;
    private String usu_Password;
    private String usu_Estado;
    private Date usu_FechaHasta;
    private Date usu_FechaRegistro;
    private String usu_usuarioRegistro;
    private Date usu_FechaModificacion;
    private String usu_usuarioModificacion;
	public Integer getUsu_Id() {
		return usu_Id;
	}
	public void setUsu_Id(Integer usu_Id) {
		this.usu_Id = usu_Id;
	}
	public String getUsu_Codigo() {
		return usu_Codigo;
	}
	public void setUsu_Codigo(String usu_Codigo) {
		this.usu_Codigo = usu_Codigo;
	}
	public entPersona getPersona() {
		return persona;
	}
	public void setPersona(entPersona persona) {
		this.persona = persona;
	}
	public entTipoUsuario getTipo_Usuario() {
		return tipo_Usuario;
	}
	public void setTipo_Usuario(entTipoUsuario tipo_Usuario) {
		this.tipo_Usuario = tipo_Usuario;
	}
	public String getUsu_Login() {
		return usu_Login;
	}
	public void setUsu_Login(String usu_Login) {
		this.usu_Login = usu_Login;
	}
	public String getUsu_Password() {
		return usu_Password;
	}
	public void setUsu_Password(String usu_Password) {
		this.usu_Password = usu_Password;
	}
	public String getUsu_Estado() {
		return usu_Estado;
	}
	public void setUsu_Estado(String usu_Estado) {
		this.usu_Estado = usu_Estado;
	}
	public Date getUsu_FechaHasta() {
		return usu_FechaHasta;
	}
	public void setUsu_FechaHasta(Date usu_FechaHasta) {
		this.usu_FechaHasta = usu_FechaHasta;
	}
	public Date getUsu_FechaRegistro() {
		return usu_FechaRegistro;
	}
	public void setUsu_FechaRegistro(Date usu_FechaRegistro) {
		this.usu_FechaRegistro = usu_FechaRegistro;
	}
	public String getUsu_usuarioRegistro() {
		return usu_usuarioRegistro;
	}
	public void setUsu_usuarioRegistro(String usu_usuarioRegistro) {
		this.usu_usuarioRegistro = usu_usuarioRegistro;
	}
	public Date getUsu_FechaModificacion() {
		return usu_FechaModificacion;
	}
	public void setUsu_FechaModificacion(Date usu_FechaModificacion) {
		this.usu_FechaModificacion = usu_FechaModificacion;
	}
	public String getUsu_usuarioModificacion() {
		return usu_usuarioModificacion;
	}
	public void setUsu_usuarioModificacion(String usu_usuarioModificacion) {
		this.usu_usuarioModificacion = usu_usuarioModificacion;
	}
    
    
    
}
