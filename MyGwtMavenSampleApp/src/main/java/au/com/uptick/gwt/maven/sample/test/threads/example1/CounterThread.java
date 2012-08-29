package au.com.uptick.gwt.maven.sample.test.threads.example1;

public class CounterThread extends Thread{

	Counter counter;
	
	public CounterThread(Counter counter) {
		
		super();
		this.counter = counter;
	}

	@Override
	public void run() {

		callMethod();
	}

	public synchronized void callMethod() {
		
		for (int i = 0; i < 10; i++) {
			counter.add(i);
		}
	}

}
