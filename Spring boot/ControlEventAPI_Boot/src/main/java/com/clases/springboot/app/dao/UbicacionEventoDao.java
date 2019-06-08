package com.clases.springboot.app.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;


import com.clases.springboot.app.model.entUbicacionEvento;
import com.clases.springboot.app.service.IUbicacionEvento;

public class UbicacionEventoDao implements IUbicacionEvento {

	// Singleton
	public static UbicacionEventoDao _Instancia;
		private UbicacionEventoDao(){
	};
	public static UbicacionEventoDao Instancia(){
		if(_Instancia==null){
			_Instancia = new UbicacionEventoDao();
	}
		return _Instancia;
	}
	// end singleton
	
	@Override
	public entUbicacionEvento Recuperar(int id) throws Exception {
		Connection cn = null;
		entUbicacionEvento ce = null;
		try {
			cn = Conexion.Instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call spDevuelveUbicacionEvento (?)}");
			cst.setInt("prmtIntId", id);
			ResultSet rs = cst.executeQuery();
			if (rs.next()) {
				ce = new entUbicacionEvento();
				ce.setUbiEve_Id(rs.getInt("UbiEve_Id"));
				ce.setUbiEve_Latitud(rs.getString("UbiEve_Latitud"));
				ce.setUbiEve_Longitud(rs.getString("UbiEve_Longitud"));
			}
		} catch (Exception e) {
			System.out.print("Recuperar : "+e.getMessage() +"\n");
			throw e;
		} finally {
			cn.close();
		}
		return ce;
	}

	@Override
	public entUbicacionEvento Insertar(entUbicacionEvento te) throws Exception {
		Connection cn = null;
		entUbicacionEvento ce = null;
		int id = 0;
		try {			
			cn = Conexion.Instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{?= call spInsertaUbicacionEvento (?,?)}");
			cst.registerOutParameter(1, java.sql.Types.INTEGER);
			cst.setString("prmtStrLatitud", te.getUbiEve_Latitud());
			cst.setString("prmtStrLongitud", te.getUbiEve_Longitud());
			cst.execute();
			id = cst.getInt(1);
			
			ce = Recuperar(id);
		} catch (Exception e) {
			System.out.print("Insertar: "+e.getMessage() + "\n");
			throw e;
		} finally {
			cn.close();
		}
		return ce;
	}

}
