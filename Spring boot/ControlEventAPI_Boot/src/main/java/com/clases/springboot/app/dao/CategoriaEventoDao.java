package com.clases.springboot.app.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.clases.springboot.app.model.entCategoriaEvento;
import com.clases.springboot.app.service.ICategoriaEvento;

public class CategoriaEventoDao implements ICategoriaEvento {
	// Singleton
	public static CategoriaEventoDao _Instancia;
		private CategoriaEventoDao(){
	};
	public static CategoriaEventoDao Instancia(){
		if(_Instancia==null){
			_Instancia = new CategoriaEventoDao();
	}
		return _Instancia;
	}
	// end singleton
	
	@Override
	public List<entCategoriaEvento> Listar() throws Exception {
		Connection cn = null;
		List<entCategoriaEvento> lista = null;
		try {			
			cn = Conexion.Instancia().Conectar();
			lista = new ArrayList<entCategoriaEvento>();			
			CallableStatement cst = cn.prepareCall("spListaCategoriaEvento");
			ResultSet rs = cst.executeQuery();			
			while(rs.next()) {					
				entCategoriaEvento p = new entCategoriaEvento();					
				p.setCatEve_Id(rs.getInt("CatEve_Id"));
				p.setCatEve_codigo(rs.getString("CatEve_Codigo"));
				p.setCatEve_Nombre(rs.getString("CatEve_Nombre"));
				p.setCatEve_Descripcion(rs.getString("CatEve_Descripcion"));				
				lista.add(p);
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
	public entCategoriaEvento Recuperar(int id) throws Exception {
		Connection cn = null;
		entCategoriaEvento ce = null;
		try {
			cn = Conexion.Instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call spBuscarCategoriaEventoxID (?)}");
			cst.setInt("prmtIntId", id);
			ResultSet rs = cst.executeQuery();
			if (rs.next()) {
				ce = new entCategoriaEvento();
				ce.setCatEve_Id(rs.getInt("CatEve_Id"));
				ce.setCatEve_codigo(rs.getString("CatEve_Codigo"));
				ce.setCatEve_Nombre(rs.getString("CatEve_Nombre"));
				ce.setCatEve_Descripcion(rs.getString("CatEve_Descripcion"));	
			}
		} catch (Exception e) {
			System.out.print("Recuperar : "+e.getMessage() +"\n");
			throw e;
		} finally {
			cn.close();
		}
		return ce;
	}
	
	public entCategoriaEvento Devuelve(int id) throws Exception {
		Connection cn = null;
		entCategoriaEvento ce = null;
		try {
			cn = Conexion.Instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call spDevInaCategoriaEventoxID (?)}");
			cst.setInt("prmtIntId", id);
			ResultSet rs = cst.executeQuery();
			if (rs.next()) {
				ce = new entCategoriaEvento();
				ce.setCatEve_Id(rs.getInt("CatEve_Id"));
				ce.setCatEve_codigo(rs.getString("CatEve_Codigo"));
				ce.setCatEve_Nombre(rs.getString("CatEve_Nombre"));
				ce.setCatEve_Descripcion(rs.getString("CatEve_Descripcion"));
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
	public entCategoriaEvento Insertar(entCategoriaEvento te) throws Exception {
		Connection cn = null;
		entCategoriaEvento ce = null;
		int id = 0;
		try {			
			cn = Conexion.Instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call spInsertarCategoriaEvento (?,?)}");
			cst.setString("prmtStrNombre", te.getCatEve_Nombre());
			cst.setString("prmtStrDescripcion", te.getCatEve_Descripcion());
						
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
	public entCategoriaEvento Actualizar(entCategoriaEvento te) throws Exception {
		Connection cn = null;
		entCategoriaEvento ce = null;
		//int id = 0;
		try {
			cn = Conexion.Instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call spActualizaCategoriaEvento (?,?,?)}");
			cst.setString("prmtStrNombre", te.getCatEve_Nombre());
			cst.setString("prmtStrDescripcion", te.getCatEve_Descripcion());
			cst.setInt("prmtIntId", te.getCatEve_Id());		
			cst.executeUpdate();
			ce = Recuperar(te.getCatEve_Id());
		} catch (Exception e) {
			System.out.print("Actualizar: "+e.getMessage() + "\n");
			throw e;
		} finally {
			cn.close();
		}
		return ce;
	}

	@Override
	public entCategoriaEvento Eliminar(int id) throws Exception {
		Connection cn = null;
		entCategoriaEvento ce = null;
		try {
			cn = Conexion.Instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call spEliminaCategoriaEvento (?)}");			
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
