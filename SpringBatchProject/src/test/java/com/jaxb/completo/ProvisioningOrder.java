
package com.jaxb.completo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchema;

@XmlRootElement(name = "ProvisioningOrders")
@XmlAccessorType(XmlAccessType.FIELD)

public class ProvisioningOrder {
	
	@XmlAttribute(name = "generateReport")
	private String getReport;
	
	@XmlElement(name = "Order")
	private List<Order> order;

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public String getGetReport() {
		return getReport;
	}

	public void setGetReport(String getReport) {
		this.getReport = getReport;
	}
	
}
