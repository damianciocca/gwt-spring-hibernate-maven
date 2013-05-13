package com.springbatch.ejemplo10;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class SubscribedOptions {
	
	@XmlElement(name = "SubscribedOption")
	List<SubscribedOption> subscribedOptions;

	public List<SubscribedOption> getSubscribedOptions() {
		return subscribedOptions;
	}

	public void setSubscribedOptions(List<SubscribedOption> subscribedOptions) {
		this.subscribedOptions = subscribedOptions;
	}
	
	

}
