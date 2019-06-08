package com.clases.springboot.app.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.clases.springboot.app.model.entPersona;
import com.clases.springboot.app.model.entTipoUsuario;
import com.clases.springboot.app.model.entUsuario;
import com.clases.springboot.app.service.IUsuario;
import com.clases.springboot.app.utils.Utils;

public class UsuarioDao implements IUsuario{

	// Singleton
	public static UsuarioDao _Instancia;
		private UsuarioDao(){
	};
	public static UsuarioDao Instancia(){
		if(_Instancia==null){
			_Instancia = new UsuarioDao();
	}
		return _Instancia;
	}
	// end singleton
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");  
	
	@Override
	public Integer UserInsUpdDelBlo(entUsuario u, Integer TipoEdicion) throws Exception {
		String cadXML = "";
        Integer i = 0; 
		try {
			if (TipoEdicion == 1 || TipoEdicion == 2) {
                cadXML = ConstruirInsUpdXML(u, TipoEdicion);
            } else if (TipoEdicion == 3 || TipoEdicion == 4 || TipoEdicion == 5) {
                cadXML = OtherConstruirXML(u, TipoEdicion);
            }      
            i = InsUpdDelBloActUsuario(cadXML);
		} catch (Exception e) {
			System.out.print("UserInsUpdDelBlo : "+e.getMessage() +"\n");
			throw e;
		}
		return i;
	}
	@Override
	public entUsuario VerificarAccesoIntranet(String prmstrLogin, String prmstrPassw) throws Exception {
		Connection cn = null;
		entUsuario ce = null;
		try {
			cn = Conexion.Instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call spVerificarAccesoIntranet (?,?)}");
			cst.setString("prmstrLogin", prmstrLogin);
			cst.setString("prmstrPassw", prmstrPassw);
			ResultSet rs = cst.executeQuery();
			if (rs.next()) {
				ce = new entUsuario();
				ce.setUsu_Id(rs.getInt("Usu_Id"));
				ce.setUsu_Codigo(rs.getString("Usu_Codigo"));
				ce.setUsu_Estado(rs.getString("Usu_Estado"));
				ce.setUsu_FechaHasta(rs.getDate("Usu_FechaHasta"));			
				
				entPersona p = new entPersona();
				p.setPer_Id(rs.getInt("Usu_Per_Id"));
				p.setPer_Codigo(rs.getString("Per_Codigo"));
				p.setPer_Nombres(rs.getString("Per_Nombres"));
				p.setPer_Apellidos(rs.getString("Per_Apellidos"));
				p.setPer_DNI(rs.getString("Per_DNI"));
				p.setPer_Celular(rs.getString("Per_Celular"));
				p.setPer_Telefono(rs.getString("Per_Telefono"));
				p.setPer_Correo(rs.getString("Per_Correo"));
				p.setPer_Direccion(rs.getString("Per_Direccion"));
				p.setPer_Foto(rs.getString("Per_Foto"));
				p.setPer_FechaNacimiento(rs.getDate("Per_FechaNacimiento"));
				p.setPer_LugarNacimiento(rs.getString("Per_LugarNacimiento"));
				ce.setPersona(p);
				
				entTipoUsuario tu = new entTipoUsuario();
				tu.setTipUsu_Id(rs.getInt("Usu_TipUsu_Id"));
				tu.setTipUsu_Nombre(rs.getString("TipUsu_Nombre"));
				tu.setTipUsu_Descripcion(rs.getString("TipUsu_Descripcion"));
				ce.setTipo_Usuario(tu);
			}			
		} catch (Exception e) {
			System.out.print("VerificarAccesoIntranet : "+e.getMessage() +"\n");
			throw e;
		} finally {
			cn.close();
		}
		return ce;
	}
	
	public String ConstruirInsUpdXML(entUsuario u , Integer TipoEdicion) throws Exception {        
		String res = "";
		try {
			
			Document document = null;
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();				
			
			DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "root", null);
            document.setXmlVersion("1.0"); 

            Element util = document.createElement("Util");
            util.setAttribute("TipoEdicion", TipoEdicion.toString());
            
            Element persona = document.createElement("Persona");
            persona.setAttribute("Per_Id", u.getPersona().getPer_Id().toString());
            persona.setAttribute("Per_Nombres",u.getPersona().getPer_Nombres());
            persona.setAttribute("Per_Apellidos",u.getPersona().getPer_Apellidos());
            persona.setAttribute("Per_DNI",u.getPersona().getPer_DNI());
            persona.setAttribute("Per_Celular",u.getPersona().getPer_Celular());
            persona.setAttribute("Per_Telefono",u.getPersona().getPer_Telefono());
            persona.setAttribute("Per_Correo",u.getPersona().getPer_Correo());
            persona.setAttribute("Per_Direccion",u.getPersona().getPer_Direccion());
            persona.setAttribute("Per_Foto",u.getPersona().getPer_Foto());
            persona.setAttribute("Per_FechaNacimiento",dateFormat.format(u.getPersona().getPer_FechaNacimiento()));
            persona.setAttribute("Per_LugarNacimiento",u.getPersona().getPer_LugarNacimiento());
            persona.setAttribute("TipoEdicion",TipoEdicion.toString());
            
            Element usuario = document.createElement("Usuario");
            usuario.setAttribute("Usu_Id", u.getUsu_Id().toString());
            usuario.setAttribute("Usu_TipUsu_Id", u.getTipo_Usuario().getTipUsu_Id().toString());
            usuario.setAttribute("Usu_FechaHasta", dateFormat.format(u.getUsu_FechaHasta()));
            usuario.setAttribute("Usu_UsuarioRegistro", u.getUsu_usuarioRegistro());
            usuario.setAttribute("Usu_UsuarioModificacion", u.getUsu_usuarioModificacion());
            usuario.setAttribute("TipoEdicion",TipoEdicion.toString());
            persona.appendChild(usuario); 
            
            document.getDocumentElement().appendChild(util); 
            document.getDocumentElement().appendChild(persona);            
                      
            res = Utils.Instancia().ConvertXMLtoString(document);
		} catch (Exception e) {
			System.out.print("ConstruirInsUpdXML : "+e.getMessage() +"\n");
			throw e;
		}
		return res;
	}

	public String OtherConstruirXML(entUsuario u , Integer TipoEdicion) throws Exception {        
		String res = "";
		try {
			
			Document document = null;
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();				
			
			DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "root", null);
            document.setXmlVersion("1.0"); 

            Element util = document.createElement("Util");
            util.setAttribute("TipoEdicion", TipoEdicion.toString());         
            
            Element usuario = document.createElement("Usuario");
            usuario.setAttribute("Usu_Id", u.getUsu_Id().toString());
            usuario.setAttribute("Usu_UsuarioModificacion", u.getUsu_usuarioModificacion());
            usuario.setAttribute("TipoEdicion",TipoEdicion.toString());
            
            document.getDocumentElement().appendChild(util); 
            document.getDocumentElement().appendChild(usuario);             
              
            res = Utils.Instancia().ConvertXMLtoString(document);			
		} catch (Exception e) {
			System.out.print("ConstruirInsUpdXML : "+e.getMessage() +"\n");
			throw e;
		}
		return res;
	}

	public int InsUpdDelBloActUsuario(String cadXML) throws Exception  {
		Connection cn = null;
		int  i = 0;
		try {
			cn = Conexion.Instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{ ? = call spIsnUpdDelBloActUsuario (?)}");
			cst.registerOutParameter(1, java.sql.Types.INTEGER);
			cst.setString("prmstrCadXML", cadXML);
			cst.execute();
			i = cst.getInt(1);			
		} catch (Exception e) {
			System.out.print("InsUpdDelBloActUsuario : "+e.getMessage() +"\n");
			throw e;
		} finally {
			cn.close();
		}
		return i;
	}
}
