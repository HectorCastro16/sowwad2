package com.clases.springboot.app.utils;

import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class Utils {
	// Singleton
	public static Utils _Instancia;
		private Utils(){
	};
	public static Utils Instancia(){
		if(_Instancia==null){
			_Instancia = new Utils();
	}
		return _Instancia;
	}
	// end singleton
	
	public String ConvertXMLtoString(Document document) throws Exception  {
		String res = "";
		try {
			TransformerFactory transFact = TransformerFactory.newInstance();
		    transFact.setAttribute("indent-number", new Integer(3));
		    Transformer trans = transFact.newTransformer();
		    trans.setOutputProperty(OutputKeys.INDENT, "yes");
		    trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
		    //trans.setOutputProperty(OutputKeys.STANDALONE, null);
		    trans.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");		    
		    StringWriter sw = new StringWriter();
		    StreamResult sr = new StreamResult(sw);         
            DOMSource domSource = new DOMSource(document);
            trans.transform(domSource, sr);   
            res = sw.toString();	
		} catch (Exception e) {
			System.out.print("ConvertXMLtoString : "+e.getMessage() +"\n");
			throw e;
		}
		return res;
	}
}
