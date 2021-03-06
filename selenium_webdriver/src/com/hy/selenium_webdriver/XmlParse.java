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

import android.R.integer;
import android.R.string;
import android.graphics.SumPathEffect;

public class XmlParse {
	
	private InputStream in;
	private Document doc;
	private String[] titleNameGroup;
	
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
	

	//获取全部节点的属性值形成list
	public String[] getTitleValue(String childNode, String childNodeAttribute){
		NodeList nodeList = doc.getElementsByTagName(childNode);
	
		int sum = nodeList.getLength();
		titleNameGroup = new String[sum];
		for(int i=0; i < sum; i++){
			Node node = nodeList.item(i);
			NamedNodeMap map = node.getAttributes();
			String titleName = map.getNamedItem(childNodeAttribute).getNodeValue();
			
			titleNameGroup[i] = titleName;
		}
		 
		return titleNameGroup;	
	}
	
	//依靠index获取节点属性值
	public String getIndexTitle(int index) {
		return titleNameGroup[index];
	}
	
	//获取节点文本
	public String getContent(String childNode, int index){

		Node node = doc.getElementsByTagName(childNode).item(index);
		String content = node.getTextContent();
		return content;
	}
	
}
