package au.com.uptick.gwt.maven.sample.test.threads.example3.bis;

public class TP extends Thread {
	
	Elemento elemento=null;
	
	TP(Elemento elemento){
		this.elemento = elemento;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			elemento.setElemento(String.valueOf(i));
		}
	}
	
	
} 
