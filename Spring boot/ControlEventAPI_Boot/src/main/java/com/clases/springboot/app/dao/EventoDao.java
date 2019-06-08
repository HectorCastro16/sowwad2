package com.clases.springboot.app.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.clases.springboot.app.model.entEvento;
import com.clases.springboot.app.service.IEvento;
import com.clases.springboot.app.utils.Utils;

public class EventoDao implements IEvento{

	// Singleton
	public static EventoDao _Instancia;
		private EventoDao(){
	};
	public static EventoDao Instancia(){
		if(_Instancia==null){
			_Instancia = new EventoDao();
	}
		return _Instancia;
	}
	// end singleton
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");  
		
	@Override
	public Integer EventoInsUpdDel(entEvento u, Integer TipoEdicion) throws Exception {
		String cadXML = "";
        Integer i = 0; 
		try {
			if (TipoEdicion == 1 || TipoEdicion == 2) {
                cadXML = ConstruirInsUpdXML(u, TipoEdicion);
            } else if (TipoEdicion == 3 || TipoEdicion == 4) {
                cadXML = OtherConstruirXML(u, TipoEdicion);
            }      
            i = InsUpdDelEvento(cadXML);
		} catch (Exception e) {
			System.out.print("UserInsUpdDelBlo : "+e.getMessage() +"\n");
			throw e;
		}
		return i;
	}
		
	public String ConstruirInsUpdXML(entEvento u , Integer TipoEdicion) throws Exception {        
		String res = "";
		try {			
			Document document = null;
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();				
			
			DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "root", null);
            document.setXmlVersion("1.0"); 
                       
            Element evento = document.createElement("Evento");
            evento.setAttribute("Eve_Id", u.getEve_Id().toString());
            evento.setAttribute("Eve_Link_Site_oficial",u.getEve_Link_Site_oficial());
            evento.setAttribute("Eve_Lugar",u.getEve_Lugar());
            evento.setAttribute("Eve_Organizador",u.getEve_Organizador());
            evento.setAttribute("Eve_Fecha",dateFormat.format(u.getEve_Fecha()));
            evento.setAttribute("Eve_Hora",u.getEve_Hora());
            evento.setAttribute("Eve_Descripcion",u.getEve_Descripcion());
            evento.setAttribute("Eve_CatEve_Id",u.getCategoriaEvento().getCatEve_Id().toString());
            evento.setAttribute("Eve_TipEve_Id",u.getTipoEvento().getTipEve_Id().toString());
            evento.setAttribute("Eve_ModEve_Id",u.getModalidadEvento().getModEve_Id().toString());
            evento.setAttribute("Eve_UbiEve_Id",u.getUbicacionEvento().getUbiEve_Id().toString());
            evento.setAttribute("TipoEdicion",TipoEdicion.toString());            
                        
            document.getDocumentElement().appendChild(evento);            
                      
            res = Utils.Instancia().ConvertXMLtoString(document);
		} catch (Exception e) {
			System.out.print("ConstruirInsUpdXML : "+e.getMessage() +"\n");
			throw e;
		}
		return res;
	}

	public String OtherConstruirXML(entEvento u , Integer TipoEdicion) throws Exception {        
		String res = "";
		try {			
			Document document = null;
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();				
			
			DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "root", null);
            document.setXmlVersion("1.0");        
            
            Element usuario = document.createElement("Evento");
            usuario.setAttribute("Eve_Id", u.getEve_Id().toString());
            usuario.setAttribute("TipoEdicion",TipoEdicion.toString());
            
            document.getDocumentElement().appendChild(usuario);             
              
            res = Utils.Instancia().ConvertXMLtoString(document);			
		} catch (Exception e) {
			System.out.print("ConstruirInsUpdXML : "+e.getMessage() +"\n");
			throw e;
		}
		return res;
	}
	
	public int InsUpdDelEvento(String cadXML) throws Exception  {
		Connection cn = null;
		int  i = 0;
		try {
			cn = Conexion.Instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{ ? = call spIsnUpdActEvento (?)}");
			cst.registerOutParameter(1, java.sql.Types.INTEGER);
			cst.setString("prmstrCadXML", cadXML);
			cst.execute();
			i = cst.getInt(1);			
		} catch (Exception e) {
			System.out.print("InsUpdDelEvento : "+e.getMessage() +"\n");
			throw e;
		} finally {
			cn.close();
		}
		return i;
	}
}
