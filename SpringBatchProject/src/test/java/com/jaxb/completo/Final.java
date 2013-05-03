package com.jaxb.completo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Final", propOrder = { "minorVersion", "majorVersion", "label" })  //propOrder - defines the sequence of fields in the XML, if specified it has to specify all fields
public class Final {

	@XmlAttribute(name = "label")
	private String label;
	
	@XmlAttribute(name = "majorVersion")
	private String majorVersion;
	
	@XmlAttribute(name = "minorVersion")
	private String minorVersion;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getMajorVersion() {
		return majorVersion;
	}

	public void setMajorVersion(String majorVersion) {
		this.majorVersion = majorVersion;
	}

	public String getMinorVersion() {
		return minorVersion;
	}

	public void setMinorVersion(String minorVersion) {
		this.minorVersion = minorVersion;
	}
}
