package com.clases.springboot.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
	// Singleton
	public static Conexion _Instancia;
	private Conexion(){
	};
	public static Conexion Instancia(){
		if(_Instancia==null){
			_Instancia = new Conexion();
	}
	return _Instancia;
	}
	// end singleton
				
				
	public Connection Conectar()throws Exception{
		Connection cn= null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			cn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=BDControlEvent","sa","12345678");	
			
		} catch (Exception e) {
			throw e;
		}
		return cn;
	}

}
