package au.com.uptick.gwt.maven.sample.test.threads.example3;


public class ProductorThread implements Runnable {
	
	SharedObject sharedObject;
	
	public ProductorThread(SharedObject sharedObject) {
		super();
		this.sharedObject = sharedObject;
	}

	public void run() {
		
		for (int i = 1; i < 300; i++) {
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			sharedObject.setNumero(i);
		}
	}

}
