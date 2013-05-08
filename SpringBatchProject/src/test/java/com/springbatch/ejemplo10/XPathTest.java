package com.springbatch.ejemplo10;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XPathTest {

	public static void main(String[] args) throws Exception {

		//loading the XML document from a file
		DocumentBuilderFactory builderfactory = DocumentBuilderFactory.newInstance();
		builderfactory.setNamespaceAware(true);

		DocumentBuilder builder = builderfactory.newDocumentBuilder();
		Document xmlDocument = builder.parse(new File(XPathTest.class.getResource("test.xml").getFile().replace("%20", " ")));

		XPathFactory factory = javax.xml.xpath.XPathFactory.newInstance();
		XPath xPath = factory.newXPath();

		//getting the name of the book having an isbn number == ABCD7327923
		String isbnNum = "ABCD7327923";
		XPathExpression xPathExpression = xPath.compile("//LIBRARY//BOOKS//BOOK[@isbn='" +isbnNum + "']//NAME");
		String nameOfTheBook = xPathExpression.evaluate(xmlDocument,XPathConstants.STRING).toString();

		System.out.println("name of the Book ---> " + nameOfTheBook);

		//getting all authors for the book having an isbn number == ABCD7327923
		xPathExpression = xPath.compile("//LIBRARY//BOOKS//BOOK[@isbn='" +isbnNum + "']//AUTHORS//AUTHOR");

		NodeList nodeListBook =  (NodeList) xPathExpression.evaluate(xmlDocument,XPathConstants.NODESET);
		System.out.println("Total number of authors for the book " + nameOfTheBook + " is --> " + nodeListBook.getLength());

		for (int index = 0; index < nodeListBook.getLength(); index++) {
			String author = nodeListBook.item(index).getTextContent();
			System.out.println("Author " + (index + 1) + " ---> " + author);
		}

		//getting all tags for the dvd having id == 3213324
		String dvdID = "3213324";
		xPathExpression = xPath.compile("//LIBRARY//DVDS//DVD[@id='" +dvdID + "']");
		NodeList nodeDVD =  (NodeList) xPathExpression.evaluate(xmlDocument,XPathConstants.NODESET);
		NodeList nodeListForDVD = nodeDVD.item(0).getChildNodes();

		for (int index = 0; index < nodeDVD.item(0).getChildNodes().getLength(); index++) {
			String tagName = nodeListForDVD.item(index).getNodeName();
			String tagValue = nodeListForDVD.item(index).getTextContent();
			if(!tagName.equals("#text")) //handling empty comment (#text)
				System.out.println(tagName + " value ---> " + tagValue);
		}
	}

}
