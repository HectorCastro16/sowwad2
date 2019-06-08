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

import com.clases.springboot.app.model.entRequerimiento;
import com.clases.springboot.app.service.IRequerimiento;
import com.clases.springboot.app.utils.Utils;

public class RequerimientoDao implements IRequerimiento{
	
	// Singleton
	public static RequerimientoDao _Instancia;
		private RequerimientoDao(){
	};
	public static RequerimientoDao Instancia(){
		if(_Instancia==null){
			_Instancia = new RequerimientoDao();
	}
		return _Instancia;
	}
	// end singleton

	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");  
		
	@Override
	public Integer RequerimientoInsUpdDel(entRequerimiento u, Integer TipoEdicion) throws Exception {
		String cadXML = "";
        Integer i = 0; 
		try {
			if (TipoEdicion == 1 || TipoEdicion == 2) {
                cadXML = ConstruirInsUpdXML(u, TipoEdicion);
            } else if (TipoEdicion == 3) {
                cadXML = OtherConstruirXML(u, TipoEdicion);
            }      
            i = InsUpdDelRequerimiento(cadXML);
		} catch (Exception e) {
			System.out.print("RequerimientoInsUpdDel : "+e.getMessage() +"\n");
			throw e;
		}
		return i;
	}
		
	public String ConstruirInsUpdXML(entRequerimiento u , Integer TipoEdicion) throws Exception {        
		String res = "";
		try {			
			Document document = null;
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();				
			
			DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "root", null);
            document.setXmlVersion("1.0"); 
                       
            Element reque = document.createElement("Requerimiento");
            reque.setAttribute("Req_Id", u.getReq_Id().toString());
            reque.setAttribute("Req_Eve_Id",u.getEvento().getEve_Id().toString());
            reque.setAttribute("Req_Fecha_Inicio",dateFormat.format(u.getReq_Fecha_Inicio()));
            reque.setAttribute("Req_Fecha_Fin",dateFormat.format(u.getReq_Fecha_Fin()));
            reque.setAttribute("Req_Observaciones",u.getReq_Observaciones());
            reque.setAttribute("Req_Usu_Solicitante",u.getUsu_Solicitante().getUsu_Id().toString());
            reque.setAttribute("Req_Usu_Asignado",u.getUsu_Asignado().getUsu_Id().toString());
            reque.setAttribute("TipoEdicion",TipoEdicion.toString());            
                        
            document.getDocumentElement().appendChild(reque);            
                      
            res = Utils.Instancia().ConvertXMLtoString(document);
		} catch (Exception e) {
			System.out.print("ConstruirInsUpdXML : "+e.getMessage() +"\n");
			throw e;
		}
		return res;
	}
	
	public String OtherConstruirXML(entRequerimiento u , Integer TipoEdicion) throws Exception {        
		String res = "";
		try {			
			Document document = null;
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();				
			
			DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "root", null);
            document.setXmlVersion("1.0");        
            
            Element usuario = document.createElement("Requerimiento");
            usuario.setAttribute("Req_Id", u.getReq_Id().toString());
            usuario.setAttribute("TipoEdicion",TipoEdicion.toString());
            
            document.getDocumentElement().appendChild(usuario);             
              
            res = Utils.Instancia().ConvertXMLtoString(document);			
		} catch (Exception e) {
			System.out.print("OtherConstruirXML : "+e.getMessage() +"\n");
			throw e;
		}
		return res;
	}
	
	public int InsUpdDelRequerimiento(String cadXML) throws Exception  {
		Connection cn = null;
		int  i = 0;
		try {
			cn = Conexion.Instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{ ? = call spIsnUpdDelRequerimiento (?)}");
			cst.registerOutParameter(1, java.sql.Types.INTEGER);
			cst.setString("prmstrCadXML", cadXML);
			cst.execute();
			i = cst.getInt(1);			
		} catch (Exception e) {
			System.out.print("InsUpdDelRequerimiento : "+e.getMessage() +"\n");
			throw e;
		} finally {
			cn.close();
		}
		return i;
	}
	
}
