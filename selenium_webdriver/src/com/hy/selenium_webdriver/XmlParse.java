package com.hy.selenium_webdriver;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlParse {
	
	private InputStream in;
	private Document doc;
	private String[] titleNameGroup = {};
	
	public XmlParse(InputStream ins) {
		this.in = ins;		
		
		try {
//			byte[] by = new byte[in.available()];
//			in.read(by);
//			in.close();
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			doc = builder.parse(in);
//			in.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public String[] getTitleValue(String childNode, String childNodeAttribute){
		NodeList nodeList = doc.getElementsByTagName(childNode);

		for(int i=0; i < nodeList.getLength(); i++){
			Node node = nodeList.item(i);
			NamedNodeMap map = node.getAttributes();
			String titleName = map.getNamedItem(childNodeAttribute).getNodeValue();
			titleNameGroup[i] = titleName;
		}
		 
		return titleNameGroup;	
	}
	
	
	

	
}
