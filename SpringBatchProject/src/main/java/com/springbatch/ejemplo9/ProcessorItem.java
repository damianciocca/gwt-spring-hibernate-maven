package com.springbatch.ejemplo9;

import org.springframework.batch.item.ItemProcessor;

public class ProcessorItem implements ItemProcessor<Contact,Order>{

	@Override
	public Order process(Contact contact) throws Exception {
		
		System.out.println("PROCESS....");
		
		Order o = new Order();
		o.setTransactionId("1212121");
		
		UpdateSubscription u = new UpdateSubscription();
		u.setIccidSrc("212121");
		u.setMsisdnSrc("4343434");
		
		ServiceContent sc = new ServiceContent();
		Portal p = new Portal();
		Final f = new Final();
		f.setLabel("label");
		f.setMajorVersion("2.0.0");
		f.setMinorVersion("0.2.1");
		p.setFinalObj(f);
		sc.setPortal(p);
		
		u.setServiceContent(sc);
		
		o.setUpdateSubscription(u);
		
		return o;
	}

}
