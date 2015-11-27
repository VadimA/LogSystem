package nc.anosov.logsystem.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public final class XMLConfig {
	
	private static Document dom;
	private static String path;
	public XMLConfig(String path){
		this.path = path;
		parseXmlFile();
	}
	public static void parseXmlFile(){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try{
			
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			dom = db.parse(new File(path));
		}catch(ParserConfigurationException pce){
			pce.printStackTrace();
		}catch(SAXException se){
			se.printStackTrace();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	public String parseOutput(){
		Element root = dom.getDocumentElement();
		NodeList nl = root.getElementsByTagName("output");
		String type="";
		
		if(nl != null && nl.getLength()>0){
			for(int i =0; i < nl.getLength(); i++){
				
				Element el = (Element)nl.item(i);
				type = el.getAttribute("type");
			}
		}
		return  type;
	}
	
	public String parseLevel(){
		Element root = dom.getDocumentElement();
		NodeList nl = root.getElementsByTagName("logger");
		String level="";
		
		if(nl != null && nl.getLength()>0){
			for(int i =0; i < nl.getLength(); i++){
				
				Element el = (Element)nl.item(i);
				NodeList nodelist = el.getElementsByTagName("level");
				Element l = (Element) nodelist.item(0);
				level = l.getAttribute("value");
			}
		}
		return level;
	}
	
	public String parseMessage(){
		Element root = dom.getDocumentElement();
		NodeList nl = root.getElementsByTagName("logger");
		String message="";
		
		if(nl != null && nl.getLength()>0){
			for(int i =0; i < nl.getLength(); i++){
				
				Element el = (Element)nl.item(i);
				NodeList nodelist = el.getElementsByTagName("message");
				Element l = (Element) nodelist.item(0);
				message = l.getAttribute("value");
			}
		}
		return message;
	}
}
