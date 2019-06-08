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
			//cn=DriverManager.getConnection("jdbc:sqlserver://saleof.database.windows.net;databaseName=DBSALEOF","administrador","h3ct0rCs");	
		} catch (Exception e) {
			throw e;
		}
		return cn;
	}

}
