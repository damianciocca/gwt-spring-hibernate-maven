package com.springbatch.ejemplo10;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.springframework.batch.item.ItemProcessor;
import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ProcessorItemChangeMsisdn implements ItemProcessor<MBCard,OrderForChangeMsisdn>{
	
	String filePath;

	/**
	 * NOTA: este q no esta comentado es para el CHANGE MSISDN XML 
	 */

	public OrderForChangeMsisdn process(MBCard mbcard) throws Exception {
		
		System.out.println("PROCESSING....");
		System.out.println("MBCARD: " + mbcard.getSerialNumber());
		
		//loading the XML document from a file
		DocumentBuilderFactory builderfactory = DocumentBuilderFactory.newInstance();
		builderfactory.setNamespaceAware(true);

		DocumentBuilder builder = builderfactory.newDocumentBuilder();
		
		// IMPORTANTE: Con esto evitamos que nos pincha cuando levantamos un XML que tiene un DTD asociado
		//<!DOCTYPE CardContentModule SYSTEM "cardframework.dtd">
		builder.setEntityResolver(new EntityResolver() {
			@Override
			public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
				System.out.println("Ignoring " + publicId + ", " + systemId);
				return new InputSource(new StringReader(""));
			}
		});
		
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
		
		OrderForChangeMsisdn o = new OrderForChangeMsisdn();
		o.setTransactionId(mbcard.getSerialNumber());
		
		ChangeMsisdn cm = new ChangeMsisdn();
		cm.setCardProfile("GXX_v3.2_128K_Copy");
		cm.setCause("Activated by user");
		cm.setFinalState("ACTIVE");
		cm.setIccid("1212121212");
		cm.setImei(mbcard.getSerialNumber());
		cm.setImsi(imsi);
		cm.setMsisdn(msisdn);
		o.setChangeMsisdn(cm);

		return o;
	}
	
	/**
	 * NOTA: esto comentado es para el UPDATE SUBSCRIPTION XML 
	 */

//	public Order process(MBCard mbcard) throws Exception {
//		
//		System.out.println("PROCESSING....");
//		System.out.println("MBCARD: " + mbcard.getSerialNumber());
//		
//		//loading the XML document from a file
//		DocumentBuilderFactory builderfactory = DocumentBuilderFactory.newInstance();
//		builderfactory.setNamespaceAware(true);
//
//		DocumentBuilder builder = builderfactory.newDocumentBuilder();
//		
//		// IMPORTANTE: Con esto evitamos que nos pincha cuando levantamos un XML que tiene un DTD asociado
//		//<!DOCTYPE CardContentModule SYSTEM "cardframework.dtd">
//		builder.setEntityResolver(new EntityResolver() {
//			@Override
//			public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
//				System.out.println("Ignoring " + publicId + ", " + systemId);
//				return new InputSource(new StringReader(""));
//			}
//		});
//		
//		InputStream is = new FileInputStream(new File(filePath));
//		Document xmlDocument = builder.parse(is);
//
//		XPathFactory factory = javax.xml.xpath.XPathFactory.newInstance();
//		XPath xPath = factory.newXPath();
//
//		String serialNum = mbcard.getSerialNumber();
//		XPathExpression xPathExpression1 = xPath.compile("//CardContentModule//SimCard[@serialNumber='" +serialNum + "']//@imsi");
//		String imsi = xPathExpression1.evaluate(xmlDocument,XPathConstants.STRING).toString();
//		
//		XPathExpression xPathExpression2 = xPath.compile("//CardContentModule//SimCard[@serialNumber='" +serialNum + "']//@profileName");
//		String profile = xPathExpression2.evaluate(xmlDocument,XPathConstants.STRING).toString();
//		
//		XPathExpression xPathExpression3 = xPath.compile("//CardContentModule//SimCard[@serialNumber='" +serialNum + "']//@msisdn");
//		String msisdn = xPathExpression3.evaluate(xmlDocument,XPathConstants.STRING).toString();
//		
//		System.out.println("IMSI---> " + imsi);
//		System.out.println("PROFILE---> " + profile);
//		System.out.println("MSISDN---> " + msisdn);
//		
//		Order o = new Order();
//		o.setTransactionId(mbcard.getSerialNumber());
//		
//		UpdateSubscription us = new UpdateSubscription();
//		us.setIccidSrc("TODO");
//		us.setMsisdnSrc(msisdn);
//		us.setImsi(imsi);
//		us.setFinalState("ACTIVE");
//		us.setCause("Activated by user");
//		us.setImei(mbcard.getSerialNumber());
//		us.setGroupId("01");
//		us.setCommunicationProtocol("SMS");
//		us.setServiceExecutionProtocol("SMS");
//		
//		
//		
//		ServiceContent sc = new ServiceContent();
//		Portal p = new Portal();
//		Final f = new Final();
//		f.setLabel("Post-Paid");
//		f.setMajorVersion("1");
//		f.setMinorVersion("0");
//		p.setFinalObj(f);
//		sc.setPortal(p);
//		
//		us.setServiceContent(sc);
//		
//		SubscribeTo st = new SubscribeTo();
//		
//		Capabilities c = new Capabilities();
//		List<Capability> cList = new ArrayList<Capability>();
//		Capability c1 = new Capability();
//		c1.setKey("Prepaid");
//		c1.setValue("false");
//		Capability c2 = new Capability();
//		c2.setKey("postpaid");
//		c2.setValue("true");
//		cList.add(c1);
//		cList.add(c2);
//		c.setCapability(cList);
//		
//		st.setCapabilities(c);
//		
//		
//		SubscribedOptions so = new SubscribedOptions();
//		List<SubscribedOption> soList = new ArrayList<SubscribedOption>();
//		SubscribedOption so1 = new SubscribedOption();
//		so1.setName("NFC");
//		so1.setState("ACTIVATED");
//		soList.add(so1);
//		so.setSubscribedOptions(soList);
//		
//		st.setSubscribedOptions(so);
//		
//		us.setSubscribeTo(st);
//		us.setExecScript("public class UpdateHPLMN2 " +
//						 "{ " +
//						 "   public void script ()....");
//		
//		o.setUpdateSubscription(us);
//		
//		//throw new RuntimeException("error...");
//		return o;
//	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
}

