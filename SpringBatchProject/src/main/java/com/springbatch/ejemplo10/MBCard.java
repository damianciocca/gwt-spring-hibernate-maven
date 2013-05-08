package com.springbatch.ejemplo10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "MBCard")
@XmlAccessorType(XmlAccessType.FIELD)
public class MBCard {
	
	@XmlAttribute(name = "serialNumber")
	private String serialNumber;
	
	@XmlElement(name = "SecurityData")
	private SecurityData securityData;

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public SecurityData getSecurityData() {
		return securityData;
	}

	public void setSecurityData(SecurityData securityData) {
		this.securityData = securityData;
	}
	
}
