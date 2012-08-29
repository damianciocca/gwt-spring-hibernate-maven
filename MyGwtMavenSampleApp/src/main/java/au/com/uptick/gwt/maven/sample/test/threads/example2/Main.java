package au.com.uptick.gwt.maven.sample.test.threads.example2;

public class Main {
	
	public static void main(String[] args){
		
		NotifyAndWaitThread t1 = new NotifyAndWaitThread();
		Thread thread = new Thread(t1);
		thread.start();
		try {
			thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.addStringAndNotify("hola");
		
	}

}
