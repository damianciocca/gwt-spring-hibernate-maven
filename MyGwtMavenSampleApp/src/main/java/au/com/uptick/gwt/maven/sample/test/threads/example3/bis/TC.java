package au.com.uptick.gwt.maven.sample.test.threads.example3.bis;

public class TC extends Thread {
	
	Elemento elemento=null;
	
	TC(Elemento elemento){
		this.elemento = elemento;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
//			try {
//				Thread.sleep(6000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			elemento.getElemento();
		}
	}
	
	
} 
