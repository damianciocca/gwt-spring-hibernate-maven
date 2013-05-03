package com.jaxb.completo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class UpdateSubscription {
	
	@XmlAttribute(name = "iccidSrc")
	private String iccidSrc;
	
	@XmlAttribute(name = "msisdnSrc")
	private String msisdnSrc;
	
	@XmlElement(name = "ServiceContent")
	private ServiceContent serviceContent;

	public String getIccidSrc() {
		return iccidSrc;
	}

	public void setIccidSrc(String iccidSrc) {
		this.iccidSrc = iccidSrc;
	}

	public String getMsisdnSrc() {
		return msisdnSrc;
	}

	public void setMsisdnSrc(String msisdnSrc) {
		this.msisdnSrc = msisdnSrc;
	}

	public ServiceContent getServiceContent() {
		return serviceContent;
	}

	public void setServiceContent(ServiceContent serviceContent) {
		this.serviceContent = serviceContent;
	}
	
}
