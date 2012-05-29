package au.com.uptick.gwt.maven.sample.client.app.utils.test.threads;

public class UnThread extends Thread{

	Integer count = 0;
	
	public UnThread(String paramString) {
		super(paramString);
	}

	@Override
	public void run() {
	
		synchronized(count){
			
			for (int i = 0; i<1000; i++){
				count++;
				System.out.println(getName() + " : " + count);
			}
			
		}
	}
	
	

}
