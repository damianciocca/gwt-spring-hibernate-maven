package com.springbatch.ejemplo10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateSubscription", propOrder = { "serviceContent",
													"subscribeTo",
													"execScript",
													"serviceExecutionProtocol",
													"communicationProtocol",
													"groupId",
													"imei",
													"cause",
													"finalState",
													"imsi",
													"msisdnSrc",
													"iccidSrc" })  //propOrder - defines the sequence of fields in the XML, if specified it has to specify all fields
public class UpdateSubscription {
	
	@XmlAttribute(name = "iccidSrc")
	private String iccidSrc;
	
	@XmlAttribute(name = "msisdnSrc")
	private String msisdnSrc;
	
	@XmlAttribute(name = "imsi")
	private String imsi;
	
	@XmlAttribute(name = "finalState")
	private String finalState;
	
	@XmlAttribute(name = "cause")
	private String cause;
	
	@XmlAttribute(name = "imei")
	private String imei;
	
	@XmlAttribute(name = "groupId")
	private String groupId;
	
	@XmlAttribute(name = "communicationProtocol")
	private String communicationProtocol;
	
	@XmlAttribute(name = "serviceExecutionProtocol")
	private String serviceExecutionProtocol;
	
	@XmlElement(name = "ServiceContent")
	private ServiceContent serviceContent;

	@XmlElement(name = "SubscribeTo")
	private SubscribeTo subscribeTo;
	
	@XmlElement(name = "ExecScript")
	private String execScript;

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

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
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

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getCommunicationProtocol() {
		return communicationProtocol;
	}

	public void setCommunicationProtocol(String communicationProtocol) {
		this.communicationProtocol = communicationProtocol;
	}

	public String getServiceExecutionProtocol() {
		return serviceExecutionProtocol;
	}

	public void setServiceExecutionProtocol(String serviceExecutionProtocol) {
		this.serviceExecutionProtocol = serviceExecutionProtocol;
	}

	public SubscribeTo getSubscribeTo() {
		return subscribeTo;
	}

	public void setSubscribeTo(SubscribeTo subscribeTo) {
		this.subscribeTo = subscribeTo;
	}

	public String getExecScript() {
		return execScript;
	}

	public void setExecScript(String execScript) {
		this.execScript = execScript;
	}
	
}
