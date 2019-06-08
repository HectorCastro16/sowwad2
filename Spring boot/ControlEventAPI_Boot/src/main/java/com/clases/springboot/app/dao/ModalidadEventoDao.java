package com.clases.springboot.app.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.clases.springboot.app.model.entModalidadEvento;
import com.clases.springboot.app.service.IModalidadEvento;

public class ModalidadEventoDao implements IModalidadEvento{
	// Singleton
	public static ModalidadEventoDao _Instancia;
		private ModalidadEventoDao(){
	};
	public static ModalidadEventoDao Instancia(){
		if(_Instancia==null){
			_Instancia = new ModalidadEventoDao();
	}
		return _Instancia;
	}
	// end singleton
	
	@Override
	public List<entModalidadEvento> Listar() throws Exception {
		Connection cn = null;
		List<entModalidadEvento> lista = null;
		try {			
			cn = Conexion.Instancia().Conectar();
			lista = new ArrayList<entModalidadEvento>();			
			CallableStatement cst = cn.prepareCall("spListaModalidadEvento");
			ResultSet rs = cst.executeQuery();			
			while(rs.next()) {					
				entModalidadEvento ce = new entModalidadEvento();					
				ce.setModEve_Id(rs.getInt("ModEve_Id"));
				ce.setModEve_Codigo(rs.getString("ModEve_Codigo"));
				ce.setModEve_Nombre(rs.getString("ModEve_Nombre"));
				ce.setModEve_Descripcion(rs.getString("ModEve_Descripcion"));				
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
	public entModalidadEvento Recuperar(int id) throws Exception {
		Connection cn = null;
		entModalidadEvento ce = null;
		try {
			cn = Conexion.Instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call spBuscarModalidadEventoxID (?)}");
			cst.setInt("prmtIntId", id);
			ResultSet rs = cst.executeQuery();
			if (rs.next()) {
				ce = new entModalidadEvento();
				ce.setModEve_Id(rs.getInt("ModEve_Id"));
				ce.setModEve_Codigo(rs.getString("ModEve_Codigo"));
				ce.setModEve_Nombre(rs.getString("ModEve_Nombre"));
				ce.setModEve_Descripcion(rs.getString("ModEve_Descripcion"));
			}
		} catch (Exception e) {
			System.out.print("Recuperar : "+e.getMessage() +"\n");
			throw e;
		} finally {
			cn.close();
		}
		return ce;
	}
	
	public entModalidadEvento Devuelve(int id) throws Exception {
		Connection cn = null;
		entModalidadEvento ce = null;
		try {
			cn = Conexion.Instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call spDevInaModalidadEventoxID (?)}");
			cst.setInt("prmtIntId", id);
			ResultSet rs = cst.executeQuery();
			if (rs.next()) {
				ce = new entModalidadEvento();
				ce.setModEve_Id(rs.getInt("ModEve_Id"));
				ce.setModEve_Codigo(rs.getString("ModEve_Codigo"));
				ce.setModEve_Nombre(rs.getString("ModEve_Nombre"));
				ce.setModEve_Descripcion(rs.getString("ModEve_Descripcion"));
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
	public entModalidadEvento Insertar(entModalidadEvento te) throws Exception {
		Connection cn = null;
		entModalidadEvento ce = null;
		int id = 0;
		try {			
			cn = Conexion.Instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call spInsertarModalidadEvento (?,?)}");
			cst.setString("prmtStrNombre", te.getModEve_Nombre());
			cst.setString("prmtStrDescripcion", te.getModEve_Descripcion());
						
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
	public entModalidadEvento Actualizar(entModalidadEvento te) throws Exception {
		Connection cn = null;
		entModalidadEvento ce = null;
		//int id = 0;
		try {
			cn = Conexion.Instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call spActualizaModalidadEvento (?,?,?)}");
			cst.setString("prmtStrNombre", te.getModEve_Nombre());
			cst.setString("prmtStrDescripcion", te.getModEve_Descripcion());
			cst.setInt("prmtIntId", te.getModEve_Id());		
			cst.executeUpdate();
			ce = Recuperar(te.getModEve_Id());
		} catch (Exception e) {
			System.out.print("Actualizar: "+e.getMessage() + "\n");
			throw e;
		} finally {
			cn.close();
		}
		return ce;
	}

	@Override
	public entModalidadEvento Eliminar(int id) throws Exception {
		Connection cn = null;
		entModalidadEvento ce = null;
		try {
			cn = Conexion.Instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call spEliminaModalidadEvento (?)}");			
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
