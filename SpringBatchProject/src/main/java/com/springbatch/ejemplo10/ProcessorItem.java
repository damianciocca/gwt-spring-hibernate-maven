package com.springbatch.ejemplo10;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.springframework.batch.item.ItemProcessor;
import org.w3c.dom.Document;

public class ProcessorItem implements ItemProcessor<MBCard,Order>{
	
	String filePath;

	public Order process(MBCard mbcard) throws Exception {
		
		System.out.println("PROCESSING....");
		System.out.println("MBCARD: " + mbcard.getSerialNumber());
		
		//loading the XML document from a file
		DocumentBuilderFactory builderfactory = DocumentBuilderFactory.newInstance();
		builderfactory.setNamespaceAware(true);

		DocumentBuilder builder = builderfactory.newDocumentBuilder();
		
		InputStream is = new FileInputStream(new File(filePath));
		Document xmlDocument = builder.parse(is);

		XPathFactory factory = javax.xml.xpath.XPathFactory.newInstance();
		XPath xPath = factory.newXPath();

		String serialNum = mbcard.getSerialNumber();
		XPathExpression xPathExpression1 = xPath.compile("//CardContentModule//SimCard[@serialNumber='" +serialNum + "']//@imsi");
		String imsi = xPathExpression1.evaluate(xmlDocument,XPathConstants.STRING).toString();
		
		XPathExpression xPathExpression2 = xPath.compile("//CardContentModule//SimCard[@serialNumber='" +serialNum + "']//@profileName");
		String profile = xPathExpression2.evaluate(xmlDocument,XPathConstants.STRING).toString();
		
		XPathExpression xPathExpression3 = xPath.compile("//CardContentModule//SimCard[@serialNumber='" +serialNum + "']//@msisdn");
		String msisdn = xPathExpression3.evaluate(xmlDocument,XPathConstants.STRING).toString();
		
		System.out.println("IMSI---> " + imsi);
		System.out.println("PROFILE---> " + profile);
		System.out.println("MSISDN---> " + msisdn);
		
		Order o = new Order();
		o.setTransactionId(mbcard.getSerialNumber());
		
		UpdateSubscription us = new UpdateSubscription();
		us.setIccidSrc("TODO");
		us.setMsisdnSrc(msisdn);
		
		o.setUpdateSubscription(us);
		
		
		return o;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
}
