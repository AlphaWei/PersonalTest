package com.eshafts.module.language;

import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author AlphaWei
 *
 */
public class LoadResource{
	
	public static ResourceBundle RESOURCES;

	public static void initLang(String lang){
		
		File file = null;
		Locale locale;
		if(lang == null){
			lang = "EN";
		}
		switch(lang){
		case "EN":
			locale = new Locale("en", "EN");
			RESOURCES = ResourceBundle.getBundle("com/eshafts/resources/i18n/resource", locale);
			break;
		case "CN":
			locale = new Locale("zh", "CN");
			RESOURCES = ResourceBundle.getBundle("com/eshafts/resources/i18n/resource", locale);
			break;
		default : 
		}
		
		if(file == null || !file.exists()){
			//TODO download lang file  default is en
		}
	}
}
