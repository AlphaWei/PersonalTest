package com.eshafts.utils.configuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class LoadConfig {
	
	private static Document document;
	
	private static final String CONF_PATH = System.getProperty("user.dir") + "\\config\\conf.xml";
	
	public static final LoadConfig GLOBAL_SET = new LoadConfig();
	
	private LoadConfig(){
		loadXmlFile();
	}
	
	public String getConfig(String key) {
		if(document == null){
			return null;
		}
		Element ele = document.getRootElement();
		return ele.element(key).getText();
	}

	/**
	 * ���������ļ�
	 */
	private static void loadXmlFile(){
		
        SAXReader reader = new SAXReader();
        
		File file = new File(CONF_PATH);
		if (!file.exists()) {
		    document = DocumentHelper.createDocument();
		    document.addElement("global_conf");
		    writer(document);
		    setDefault(document);
		} else {
		    try {
				document = reader.read(file);
			} catch (DocumentException ex) {
				Logger.getLogger(LoadConfig.class.getName()).log(Level.CONFIG, "read config file exception", ex);;
			}
		    document.normalize();
		}
	}
	
	 private static void writer(Document document){  
		 // �Ű������ĸ�ʽ  
		 OutputFormat format = OutputFormat.createPrettyPrint();  
		 // ���ñ���  
		 format.setEncoding("UTF-8");  
		 // ����XMLWriter����,ָ����д���ļ��������ʽ  
		 XMLWriter writer;
		try {
			writer = new XMLWriter(new OutputStreamWriter(  
			         new FileOutputStream(new File(CONF_PATH)), "UTF-8"), format);
			
			writer.write(document);  
			writer.flush();  
			writer.close();  
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
		 
	} 

	
	/**
	 * �ָ�Ĭ������
	 * @param doc
	 */
	private static void setDefault(Document doc){
		//TODO
	}
	
	public static void main(String args[]){
		System.out.println(LoadConfig.GLOBAL_SET.getConfig("sysLang"));
	}
	
}
