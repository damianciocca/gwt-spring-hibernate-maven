package au.com.uptick.gwt.maven.sample.test.threads.example3;

public class Main {
	
	public static void main(String arg[]){
		
		SharedObject sharedObject = new SharedObject();
		ProductorThread productor = new ProductorThread(sharedObject);
		ConsumidorThread consumidor = new ConsumidorThread(sharedObject);
		Thread t1 = new Thread(productor);
		Thread t2 = new Thread(consumidor);
		t1.start();
		t2.start();
		
	}

}
