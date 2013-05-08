package com.springbatch.ejemplo10;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Key {
	
	@XmlElement(name = "KeyValue")
	private List<KeyValue> keyvalues;

	public List<KeyValue> getKeyvalues() {
		return keyvalues;
	}

	public void setKeyvalues(List<KeyValue> keyvalues) {
		this.keyvalues = keyvalues;
	}

}
