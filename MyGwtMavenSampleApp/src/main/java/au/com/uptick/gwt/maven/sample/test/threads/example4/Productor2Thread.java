package au.com.uptick.gwt.maven.sample.test.threads.example4;

public class Productor2Thread implements Runnable{

	SharedValueObj sharedValueObj = new SharedValueObj();
	
	public Productor2Thread(SharedValueObj sharedValueObj) {
		super();
		this.sharedValueObj = sharedValueObj;
	}

	public void run() {
		
		for (int i = 0; i < 20; i++) {
			
			sharedValueObj.setNumero(i);
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}
	
	

}
