package com.jaxb.completo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "MBCardModule")
@XmlAccessorType(XmlAccessType.FIELD)
public class MBCardModule {

	@XmlElement(name = "MBCard")
	private List<MBCard> mbCard;

	public List<MBCard> getMbCard() {
		return mbCard;
	}

	public void setMbCard(List<MBCard> mbCard) {
		this.mbCard = mbCard;
	}

	@Override
	public String toString() {
		return "MBCardModule [mbCard=" + mbCard + "]";
	}
	
}
