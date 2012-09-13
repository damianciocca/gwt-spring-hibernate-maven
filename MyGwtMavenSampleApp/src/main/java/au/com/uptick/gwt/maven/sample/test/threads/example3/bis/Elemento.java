package au.com.uptick.gwt.maven.sample.test.threads.example3.bis;


public class Elemento {
	String elemento ="";
	boolean hayDato = false;

	public synchronized String getElemento() {
		try {
			if(hayDato){
				hayDato = false;
				System.out.println("TC => saca "+elemento);
				notifyAll();
				wait();
			}else{
				wait();
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return elemento;
	}

	public synchronized void setElemento(String elemento) {
		try {
			if(hayDato){
				wait();
			}else{
				this.elemento = elemento;
				System.out.println("TP => pone "+elemento);
				hayDato = true;
				notifyAll();
				wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
