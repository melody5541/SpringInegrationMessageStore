package com.hsbc.srbp.commonMsg.domain;

import java.io.Serializable;
import java.util.HashMap;

import org.springframework.core.serializer.Serializer;

public class CommonMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	HashMap<String,Object> map;
	
	public HashMap<String, Object> getMap() {
		return map;
	}

	public void setMap(HashMap<String, Object> map) {
		this.map = map;
	}

	@Override
	public String toString() {
		return "CommonMessage [map=" + map + "]";
	}
	
}
