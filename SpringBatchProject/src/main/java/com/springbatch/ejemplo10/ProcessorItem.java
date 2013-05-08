package com.springbatch.ejemplo10;

import org.springframework.batch.item.ItemProcessor;

public class ProcessorItem implements ItemProcessor<MBCard,Order>{

	public Order process(MBCard contact) throws Exception {
		
		System.out.println("PROCESS....");
		
		Order o = new Order();
		o.setTransactionId("1212121");
		
		return o;
	}

}
