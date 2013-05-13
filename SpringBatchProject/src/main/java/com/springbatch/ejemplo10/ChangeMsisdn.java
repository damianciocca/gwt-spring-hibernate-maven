package com.springbatch.ejemplo10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class ChangeMsisdn {
	
	@XmlAttribute(name = "iccid")
	private String iccid;
	
	@XmlAttribute(name = "imsi")
	private String imsi;

	@XmlAttribute(name = "msisdn")
	private String msisdn;
	
	@XmlAttribute(name = "imei")
	private String imei;
	
	@XmlAttribute(name = "cardProfile")
	private String cardProfile;
	
	@XmlAttribute(name = "finalState")
	private String finalState;
	
	@XmlAttribute(name = "cause")
	private String cause;

	public String getIccid() {
		return iccid;
	}

	public void setIccid(String iccid) {
		this.iccid = iccid;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getCardProfile() {
		return cardProfile;
	}

	public void setCardProfile(String cardProfile) {
		this.cardProfile = cardProfile;
	}

	public String getFinalState() {
		return finalState;
	}

	public void setFinalState(String finalState) {
		this.finalState = finalState;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}
	
}
