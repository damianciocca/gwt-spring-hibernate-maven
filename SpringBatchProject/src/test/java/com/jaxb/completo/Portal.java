package com.jaxb.completo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Portal {

	@XmlElement(name = "Final")
	private Final finalObj;

	public Final getFinalObj() {
		return finalObj;
	}

	public void setFinalObj(Final finalObj) {
		this.finalObj = finalObj;
	}
	
}
