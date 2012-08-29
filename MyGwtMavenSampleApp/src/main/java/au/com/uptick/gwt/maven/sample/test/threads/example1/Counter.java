package au.com.uptick.gwt.maven.sample.test.threads.example1;

public class Counter {
	
	int count=0;
	
	public void add(int value){
		
		this.count = value;
		System.out.println("COUNT " + this.count);
	}

}
