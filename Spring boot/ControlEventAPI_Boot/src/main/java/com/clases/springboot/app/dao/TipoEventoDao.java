package com.clases.springboot.app.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.clases.springboot.app.service.ITipoEvento;

import com.clases.springboot.app.dao.Conexion;
import com.clases.springboot.app.model.entTipoEvento;

public class TipoEventoDao implements ITipoEvento {

	// Singleton
	public static TipoEventoDao _Instancia;
		private TipoEventoDao(){
	};
	public static TipoEventoDao Instancia(){
		if(_Instancia==null){
			_Instancia = new TipoEventoDao();
	}
		return _Instancia;
	}
	// end singleton
			
		@Override
		public List<entTipoEvento> Listar() throws Exception {
			Connection cn = null;
			List<entTipoEvento> lista = null;
			try {			
				cn = Conexion.Instancia().Conectar();
				lista = new ArrayList<entTipoEvento>();			
				CallableStatement cst = cn.prepareCall("spListaTipoEvento");
				ResultSet rs = cst.executeQuery();			
				while(rs.next()) {					
					entTipoEvento ce = new entTipoEvento();					
					ce.setTipEve_Id(rs.getInt("TipEve_Id"));
					ce.setTipEve_Codigo(rs.getString("TipEve_Codigo"));
					ce.setTipEve_Nombre(rs.getString("TipEve_Nombre"));
					ce.setTipEve_Descripcion(rs.getString("TipEve_Descripcion"));				
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
		public entTipoEvento Recuperar(int id) throws Exception {
			Connection cn = null;
			entTipoEvento ce = null;
			try {
				cn = Conexion.Instancia().Conectar();
				CallableStatement cst = cn.prepareCall("{call spBuscarTipoEventoxID (?)}");
				cst.setInt("prmtIntId", id);
				ResultSet rs = cst.executeQuery();
				if (rs.next()) {
					ce = new entTipoEvento();
					ce.setTipEve_Id(rs.getInt("TipEve_Id"));
					ce.setTipEve_Codigo(rs.getString("TipEve_Codigo"));
					ce.setTipEve_Nombre(rs.getString("TipEve_Nombre"));
					ce.setTipEve_Descripcion(rs.getString("TipEve_Descripcion"));
				}
			} catch (Exception e) {
				System.out.print("Recuperar : "+e.getMessage() +"\n");
				throw e;
			} finally {
				cn.close();
			}
			return ce;
		}
		
		public entTipoEvento Devuelve(int id) throws Exception {
			Connection cn = null;
			entTipoEvento ce = null;
			try {
				cn = Conexion.Instancia().Conectar();
				CallableStatement cst = cn.prepareCall("{call spDevInaTipoEventoxID (?)}");
				cst.setInt("prmtIntId", id);
				ResultSet rs = cst.executeQuery();
				if (rs.next()) {
					ce = new entTipoEvento();
					ce.setTipEve_Id(rs.getInt("TipEve_Id"));
					ce.setTipEve_Codigo(rs.getString("TipEve_Codigo"));
					ce.setTipEve_Nombre(rs.getString("TipEve_Nombre"));
					ce.setTipEve_Descripcion(rs.getString("TipEve_Descripcion"));
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
		public entTipoEvento Insertar(entTipoEvento te) throws Exception {
			Connection cn = null;
			entTipoEvento ce = null;
			int id = 0;
			try {			
				cn = Conexion.Instancia().Conectar();
				CallableStatement cst = cn.prepareCall("{call spInsertarTipoEvento (?,?)}");
				cst.setString("prmtStrNombre", te.getTipEve_Nombre());
				cst.setString("prmtStrDescripcion", te.getTipEve_Descripcion());
							
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
		public entTipoEvento Actualizar(entTipoEvento te) throws Exception {
			Connection cn = null;
			entTipoEvento ce = null;
			//int id = 0;
			try {
				cn = Conexion.Instancia().Conectar();
				CallableStatement cst = cn.prepareCall("{call spActualizaTipoEvento (?,?,?)}");
				cst.setString("prmtStrNombre", te.getTipEve_Nombre());
				cst.setString("prmtStrDescripcion", te.getTipEve_Descripcion());
				cst.setInt("prmtIntId", te.getTipEve_Id());		
				cst.executeUpdate();
				ce = Recuperar(te.getTipEve_Id());
			} catch (Exception e) {
				System.out.print("Actualizar: "+e.getMessage() + "\n");
				throw e;
			} finally {
				cn.close();
			}
			return ce;
		}

		@Override
		public entTipoEvento Eliminar(int id) throws Exception {
			Connection cn = null;
			entTipoEvento ce = null;
			try {
				cn = Conexion.Instancia().Conectar();
				CallableStatement cst = cn.prepareCall("{call spEliminaTipoEvento (?)}");			
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
