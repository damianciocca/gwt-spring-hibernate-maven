package com.springbatch.ejemplo9;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CardContentModule")
@XmlAccessorType(XmlAccessType.FIELD)
public class CardContentModule {
	
	@XmlElement(name = "SimCard")
	private List<SimCard> simCard;

	public List<SimCard> getSimCard() {
		return simCard;
	}

	public void setSimCard(List<SimCard> simCard) {
		this.simCard = simCard;
	}

}
