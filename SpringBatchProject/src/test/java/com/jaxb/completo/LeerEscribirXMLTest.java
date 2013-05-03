package com.jaxb.completo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamSource;


/**
 * http://www.mkyong.com/java/jaxb-hello-world-example/
 * 
 * http://dublintech.blogspot.co.uk/2011/12/jaxb-sax-dom-performance.html
 * 
 * @author dciocca
 *
 */
public class LeerEscribirXMLTest {

	public static void main(String args[]){

		CardContentModule cm = null;
		MBCardModule mbc = null;

		System.out.println("-------1--------");
		System.out.println("XML => OBJECT..");
		System.out.println("---------------");
		// XML => OBJECT..

		try {

			// Test 1 - Using JAXB to unmarshall a Java File.	
			//File file = new File("C:\\logs\\input2.xml");
			//JAXBContext jaxbContext = JAXBContext.newInstance(CardContentModule.class);
			//Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			//cm = (CardContentModule) jaxbUnmarshaller.unmarshal(file);
			
			// Test 2 - Using JAXB to unmarshall a Streamsource
			// Test 2 is similar Test 1, except this time a Streamsource object wraps around a File object. The Streamsource object gives a hint to the JAXB implementation to stream the file.
			File file = new File("C:\\logs\\input2.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(CardContentModule.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			StreamSource source = new StreamSource(file);
			cm = (CardContentModule) jaxbUnmarshaller.unmarshal(source);
			
			
			System.out.println(cm);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		System.out.println("-------2--------");
		System.out.println("XML => OBJECT..");
		System.out.println("---------------");
		// XML => OBJECT..
		
		try {

			//File file = new File("C:\\logs\\input3.xml");
			//JAXBContext jaxbContext = JAXBContext.newInstance(MBCardModule.class);
			//Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			//mbc = (MBCardModule) jaxbUnmarshaller.unmarshal(file);
			
			File file = new File("C:\\logs\\input3.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(MBCardModule.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			StreamSource source = new StreamSource(file);
			mbc = (MBCardModule) jaxbUnmarshaller.unmarshal(source);
			
			System.out.println(mbc);

		} catch (JAXBException e) {
			e.printStackTrace();
		}


		System.out.println("---------------");
		System.out.println("OBJ => XML.....");
		System.out.println("---------------");
		// OBJ => XML
		ProvisioningOrder po = new ProvisioningOrder();
		List<Order> orders = new ArrayList<Order>();
		
		List<SimCard> simCard = cm.getSimCard();
		for (SimCard sim : simCard) {
			
			Order o = new Order();
			o.setTransactionId(sim.getProfileName());
			orders.add(o);
			
		}
		po.setOrder(orders);
		
		try {

			File file = new File("C:\\logs\\output2.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(ProvisioningOrder.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,"http://www.gemalto.com/schema/pm pmBatchFile.xsd");

			jaxbMarshaller.marshal(po, file);
			jaxbMarshaller.marshal(po, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
