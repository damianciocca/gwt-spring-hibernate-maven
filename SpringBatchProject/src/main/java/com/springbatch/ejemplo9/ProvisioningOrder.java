package com.springbatch.ejemplo9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ProvisioningOrders")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProvisioningOrder {
	
	@XmlElement(name = "Order")
	private Order order;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
}
