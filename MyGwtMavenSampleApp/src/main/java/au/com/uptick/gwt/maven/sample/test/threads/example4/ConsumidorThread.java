package au.com.uptick.gwt.maven.sample.test.threads.example4;

public class ConsumidorThread implements Runnable{

	SharedQueueObj sharedQueueObj;
	SharedValueObj sharedValueObj;
	
	public ConsumidorThread(SharedQueueObj sharedQueueObj, SharedValueObj sharedValueObj) {
		super();
		this.sharedQueueObj = sharedQueueObj;
		this.sharedValueObj = sharedValueObj;
	}


	public void run() {
		
		while(true){
			int integerFromQueue = this.sharedQueueObj.getInteger();
			//System.out.println("COLA GET " + integerFromQueue);
			int integerFromValue = this.sharedValueObj.getNumero();
			//System.out.println("VALUE GET " + integerFromValue);
			if (integerFromQueue == integerFromValue ){
				System.out.println("IGUALES => " + integerFromQueue);
			}
//			try {
//				Thread.sleep(4000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		
	}

}
