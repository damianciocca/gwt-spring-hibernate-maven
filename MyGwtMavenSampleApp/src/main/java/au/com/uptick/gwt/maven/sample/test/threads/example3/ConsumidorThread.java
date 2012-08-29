package au.com.uptick.gwt.maven.sample.test.threads.example3;

public class ConsumidorThread implements Runnable{
	
	SharedObject sharedObject;

	public ConsumidorThread(SharedObject sharedObject) {
		super();
		this.sharedObject = sharedObject;
	}

	public void run() {
		
		while (true) {
			sharedObject.getNumero();
		}
	}

}
