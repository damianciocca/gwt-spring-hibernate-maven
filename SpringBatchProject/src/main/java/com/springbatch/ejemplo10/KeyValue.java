package com.springbatch.ejemplo10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class KeyValue {

	@XmlAttribute(name = "recordNb")
	private String recordNb;
	
	@XmlAttribute(name = "value")
	private String value;
	
	@XmlAttribute(name = "algoNumber")
	private String algoNumber;

	public String getRecordNb() {
		return recordNb;
	}

	public void setRecordNb(String recordNb) {
		this.recordNb = recordNb;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getAlgoNumber() {
		return algoNumber;
	}

	public void setAlgoNumber(String algoNumber) {
		this.algoNumber = algoNumber;
	}
	
}
