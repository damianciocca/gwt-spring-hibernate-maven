package com.springbatch.ejemplo10;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class SecurityData {
	
	@XmlAttribute(name = "securityID")
	private String securityId;
	
	@XmlAttribute(name = "keysID")
	private String keysId;
	
	@XmlAttribute(name = "sync")
	private String sync;
	
	@XmlElement(name = "Keys")
	private Key keys;

}
