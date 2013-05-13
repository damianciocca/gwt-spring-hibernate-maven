package com.springbatch.ejemplo10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Order")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderForChangeMsisdn {
	
	@XmlAttribute(name = "transactionId")
	private String transactionId;
	
	@XmlElement(name = "ChangeMSISDN")
	private ChangeMsisdn changeMsisdn;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public ChangeMsisdn getChangeMsisdn() {
		return changeMsisdn;
	}

	public void setChangeMsisdn(ChangeMsisdn changeMsisdn) {
		this.changeMsisdn = changeMsisdn;
	}
	
}
