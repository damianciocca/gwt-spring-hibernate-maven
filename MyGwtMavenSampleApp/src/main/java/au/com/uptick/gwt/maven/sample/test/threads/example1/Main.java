package au.com.uptick.gwt.maven.sample.test.threads.example1;

public class Main {
	
	public static void main(String args[]){
		
		Counter c = new Counter();
		CounterThread t1 = new CounterThread(c);
		CounterThread t2 = new CounterThread(c);
		t1.start();
		t2.start();
	}

}
