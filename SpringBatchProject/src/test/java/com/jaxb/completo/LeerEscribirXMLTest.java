package com.jaxb.completo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Marshaller;


/**
 * http://www.mkyong.com/java/jaxb-hello-world-example/
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

			File file = new File("C:\\logs\\input2.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(CardContentModule.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			cm = (CardContentModule) jaxbUnmarshaller.unmarshal(file);
			System.out.println(cm);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		System.out.println("-------2--------");
		System.out.println("XML => OBJECT..");
		System.out.println("---------------");
		// XML => OBJECT..
		
		try {

			File file = new File("C:\\logs\\input3.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(MBCardModule.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			mbc = (MBCardModule) jaxbUnmarshaller.unmarshal(file);
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
