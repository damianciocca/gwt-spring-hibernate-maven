package com.springbatch.ejemplo10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class SubscribeTo {

	@XmlElement(name = "Capabilities")
	Capabilities capabilities;
	
	@XmlElement(name = "SubscribedOptions")
	private SubscribedOptions subscribedOptions;

	public Capabilities getCapabilities() {
		return capabilities;
	}

	public void setCapabilities(Capabilities capabilities) {
		this.capabilities = capabilities;
	}

	public SubscribedOptions getSubscribedOptions() {
		return subscribedOptions;
	}

	public void setSubscribedOptions(SubscribedOptions subscribedOptions) {
		this.subscribedOptions = subscribedOptions;
	}
	
}
