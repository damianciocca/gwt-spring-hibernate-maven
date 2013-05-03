package com.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.springbatch.ejemplo9.CardContentModule;
import com.springbatch.ejemplo9.Final;
import com.springbatch.ejemplo9.Order;
import com.springbatch.ejemplo9.Portal;
import com.springbatch.ejemplo9.ProvisioningOrder;
import com.springbatch.ejemplo9.ServiceContent;
import com.springbatch.ejemplo9.UpdateSubscription;

/**
 * http://www.mkyong.com/java/jaxb-hello-world-example/
 * 
 * @author dciocca
 *
 */
public class LeerEscribirXMLTest {

	public static void main(String args[]){


		System.out.println("---------------");
		System.out.println("XML => OBJECT..");
		System.out.println("---------------");
		// XML => OBJECT..

		try {

			File file = new File("C:\\logs\\input2.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(CardContentModule.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			CardContentModule customer = (CardContentModule) jaxbUnmarshaller.unmarshal(file);
			System.out.println(customer);

		} catch (JAXBException e) {
			e.printStackTrace();
		}


		System.out.println("---------------");
		System.out.println("OBJ => XML.....");
		System.out.println("---------------");
		// OBJ => XML

		ProvisioningOrder po = new ProvisioningOrder();
		Order o = new Order();
		o.setTransactionId("121212");
		
		UpdateSubscription us = new UpdateSubscription();
		us.setIccidSrc("323232");
		us.setMsisdnSrc("sasasa");
		
		ServiceContent sc = new ServiceContent();
		Portal p = new Portal();
		Final f = new Final();
		f.setLabel("label");
		f.setMajorVersion("121212");
		f.setMinorVersion("45545");
		
		p.setFinalObj(f);
		sc.setPortal(p);
		us.setServiceContent(sc);
		
		o.setUpdateSubscription(us);
		po.setOrder(o);
		
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
