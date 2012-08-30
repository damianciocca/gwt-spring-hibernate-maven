package au.com.uptick.gwt.maven.sample.test.threads.example4;

/**
 * PC: Thread productor que escribe secuencialmente Integers en una cola de mensaje.
 * 
 * @author dciocca
 */
public class Productor1Thread implements Runnable{

	SharedQueueObj sharedObj;
	
	public Productor1Thread(SharedQueueObj sharedObj) {
		super();
		this.sharedObj = sharedObj;
	}


	public void run() {
		
		for (int i = 0; i < 20; i++) {
			sharedObj.putInteger(i);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		
	}

}
