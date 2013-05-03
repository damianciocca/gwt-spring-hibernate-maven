package com.springbatch.ejemplo9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Order")
@XmlAccessorType(XmlAccessType.FIELD)
public class Order {
	
	@XmlAttribute(name = "transactionId")
	private String transactionId;
	
	@XmlElement(name = "UpdateSubscription")
	private UpdateSubscription updateSubscription;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public UpdateSubscription getUpdateSubscription() {
		return updateSubscription;
	}

	public void setUpdateSubscription(UpdateSubscription updateSubscription) {
		this.updateSubscription = updateSubscription;
	}
	
}
