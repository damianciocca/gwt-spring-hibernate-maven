package au.com.uptick.gwt.maven.sample.test.threads.example3;

public class Main {
	
	public static void main(String arg[]){
		
		/**
		 * Ejemplo del problema tipico del productor y consumidor
		 * que este ultmio vaya tomando sincronizadamente el valor
		 * que el productor haya producido y que el productor no 
		 * produzca hasta que el consumidor lo haya consumido.
		 */
		SharedObject sharedObject = new SharedObject();
		ProductorThread productor = new ProductorThread(sharedObject);
		ConsumidorThread consumidor = new ConsumidorThread(sharedObject);
		Thread t1 = new Thread(productor);
		Thread t2 = new Thread(consumidor);
		t1.start();
		t2.start();
		
	}

}
