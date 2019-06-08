package com.clases.springboot.app.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.clases.springboot.app.model.entTipoUsuario;
import com.clases.springboot.app.service.ITipoUsuario;

public class TipoUsuarioDao implements ITipoUsuario {
	// Singleton
	public static TipoUsuarioDao _Instancia;
		private TipoUsuarioDao(){
	};
	public static TipoUsuarioDao Instancia(){
		if(_Instancia==null){
			_Instancia = new TipoUsuarioDao();
	}
		return _Instancia;
	}
	// end singleton
			
	@Override
	public List<entTipoUsuario> Listar() throws Exception {
		Connection cn = null;
		List<entTipoUsuario> lista = null;
		try {			
			cn = Conexion.Instancia().Conectar();
			lista = new ArrayList<entTipoUsuario>();			
			CallableStatement cst = cn.prepareCall("spListaTipoUsuario");
			ResultSet rs = cst.executeQuery();			
			while(rs.next()) {					
				entTipoUsuario ce = new entTipoUsuario();					
				ce.setTipUsu_Id(rs.getInt("TipUsu_Id"));
				ce.setTipUsu_Codigo(rs.getString("TipUsu_Codigo"));
				ce.setTipUsu_Nombre(rs.getString("TipUsu_Nombre"));
				ce.setTipUsu_Descripcion(rs.getString("TipUsu_Descripcion"));				
				lista.add(ce);
			}			
		} catch (Exception e) {
			System.out.print("Listar : "+e.getMessage() +"\n");
			throw e;
		} finally {
			cn.close();
		}
		return lista;
	}

	@Override
	public entTipoUsuario Recuperar(int id) throws Exception {
		Connection cn = null;
		entTipoUsuario ce = null;
		try {
			cn = Conexion.Instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call spBuscarTipoUsuarioxID (?)}");
			cst.setInt("prmtIntId", id);
			ResultSet rs = cst.executeQuery();
			if (rs.next()) {
				ce = new entTipoUsuario();
				ce.setTipUsu_Id(rs.getInt("TipUsu_Id"));
				ce.setTipUsu_Codigo(rs.getString("TipUsu_Codigo"));
				ce.setTipUsu_Nombre(rs.getString("TipUsu_Nombre"));
				ce.setTipUsu_Descripcion(rs.getString("TipUsu_Descripcion"));
			}
		} catch (Exception e) {
			System.out.print("Recuperar : "+e.getMessage() +"\n");
			throw e;
		} finally {
			cn.close();
		}
		return ce;
	}
	
	public entTipoUsuario Devuelve(int id) throws Exception {
		Connection cn = null;
		entTipoUsuario ce = null;
		try {
			cn = Conexion.Instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call spDevInaTipoUsuarioxID (?)}");
			cst.setInt("prmtIntId", id);
			ResultSet rs = cst.executeQuery();
			if (rs.next()) {
				ce = new entTipoUsuario();
				ce.setTipUsu_Id(rs.getInt("TipUsu_Id"));
				ce.setTipUsu_Codigo(rs.getString("TipUsu_Codigo"));
				ce.setTipUsu_Nombre(rs.getString("TipUsu_Nombre"));
				ce.setTipUsu_Descripcion(rs.getString("TipUsu_Descripcion"));
			}
		} catch (Exception e) {
			System.out.print("Devuelve: "+e.getMessage());
			throw e;
		} finally {
			cn.close();
		}
		return ce;
	}

	@Override
	public entTipoUsuario Insertar(entTipoUsuario te) throws Exception {
		Connection cn = null;
		entTipoUsuario ce = null;
		int id = 0;
		try {			
			cn = Conexion.Instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call spInsertarTipoUsuario (?,?)}");
			cst.setString("prmtStrNombre", te.getTipUsu_Nombre());
			cst.setString("prmtStrDescripcion", te.getTipUsu_Descripcion());
						
			boolean isRs = cst.execute();
			//int updateCount = cst.getUpdateCount();
			// cs.getUpdateCount () devolverá -1 si el resultado actual es un objeto ResultSet
			// o no hay mas resultados
			// cs.getMoreResults () devolverá verdadero si el siguiente resultado es un objeto ResultSet;
			// falso si es un recuento de actualizaciones o si no hay más resultados
			while (!isRs && (cst.getUpdateCount() != -1)) {
			    isRs = cst.getMoreResults(); 
			}
			if (isRs) {
			    ResultSet rs = cst.getResultSet();
			    try {
			        if (rs.next()) {
			             id = rs.getInt("val");
			        }
			    } finally {
			        rs.close();
			    }
			}				
			ce = Recuperar(id);
		} catch (Exception e) {
			System.out.print("Insertar: "+e.getMessage() + "\n");
			throw e;
		} finally {
			cn.close();
		}
		return ce;
	}

	@Override
	public entTipoUsuario Actualizar(entTipoUsuario te) throws Exception {
		Connection cn = null;
		entTipoUsuario ce = null;
		//int id = 0;
		try {
			cn = Conexion.Instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call spActualizaTipoUsuario (?,?,?)}");
			cst.setString("prmtStrNombre", te.getTipUsu_Nombre());
			cst.setString("prmtStrDescripcion", te.getTipUsu_Descripcion());
			cst.setInt("prmtIntId", te.getTipUsu_Id());		
			cst.executeUpdate();
			ce = Recuperar(te.getTipUsu_Id());
		} catch (Exception e) {
			System.out.print("Actualizar: "+e.getMessage() + "\n");
			throw e;
		} finally {
			cn.close();
		}
		return ce;
	}

	@Override
	public entTipoUsuario Eliminar(int id) throws Exception {
		Connection cn = null;
		entTipoUsuario ce = null;
		try {
			cn = Conexion.Instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call spEliminaTipoUsuario (?)}");			
			cst.setInt("prmtIntId", id);
			cst.executeUpdate();	
			ce = Devuelve(id);
		} catch (Exception e) {
			System.out.print("Eliminar: "+e.getMessage() + "\n");
			throw e;
		} finally {
			cn.close();
		}
		return ce;
	}
}
