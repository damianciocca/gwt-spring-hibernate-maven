package au.com.uptick.gwt.maven.sample.test.threads.example2;

public class UsandoThread {
	
	public static void main(String[] args){
		
//		UnThread t1 = new UnThread("t1");
//		UnThread t2 = new UnThread("t2");
//		UnThread t3 = new UnThread("t3");
//		t1.start();
//		t2.start();
//		t3.start();
		
		SegundoThread t1 = new SegundoThread();
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
