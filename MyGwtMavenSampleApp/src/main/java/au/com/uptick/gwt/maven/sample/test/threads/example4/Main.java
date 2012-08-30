package au.com.uptick.gwt.maven.sample.test.threads.example4;


public class Main {
	
	public static void main(String arg[]){
		
		SharedQueueObj sharedObject = new SharedQueueObj();
		SharedValueObj sharedValueObj = new SharedValueObj();
		Productor1Thread productor1 = new Productor1Thread(sharedObject);
		Productor2Thread productor2 = new Productor2Thread(sharedValueObj);
		ConsumidorThread consumidor = new ConsumidorThread(sharedObject, sharedValueObj);
		Thread t1 = new Thread(productor1);
		Thread t2 = new Thread(productor2);
		Thread t3 = new Thread(consumidor);
		t1.start();
		t2.start();
		t3.start();
		
	}

}
