package com.springbatch.ejemplo10;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Capabilities {

	@XmlElement(name = "capability")
	List<Capability> capability;

	public List<Capability> getCapability() {
		return capability;
	}

	public void setCapability(List<Capability> capability) {
		this.capability = capability;
	}
	
	
}
