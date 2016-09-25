package com.eshafts.enums;

public enum GLOBAL_CONF {
	SYS_LANG("language","EN");
	
	private String key;
	private String value;
	
	private GLOBAL_CONF(String key, String value){
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String getValue(String key){
		for(GLOBAL_CONF e: GLOBAL_CONF.values()){
			if(key.equals(e.getKey()))
				return e.getValue();
		}
		return null;
	}
	
}
