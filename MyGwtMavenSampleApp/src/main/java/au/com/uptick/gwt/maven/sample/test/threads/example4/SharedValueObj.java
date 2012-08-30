package au.com.uptick.gwt.maven.sample.test.threads.example4;


/**
 * Objeto Entero que se comparte entre un thread productor (Productor2Thread)
 *  y un thread consumidor (ConsumidorThread).
 * 
 * @author dciocca
 *
 */
public class SharedValueObj {
	
	private int numero;
	boolean isAvailableToConsume = false;
	
	public synchronized int getNumero(){
		
		while (!isAvailableToConsume) {
			// No esta habilitado para consumir, por ende, tendremos que esperar que el productor setee un nuevo numero
			// para que luego el consumidor pueda obtener el valor.
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isAvailableToConsume = false;
		this.notify();
		return this.numero;
	}
	
	public synchronized void setNumero(int numero){
		
		while (isAvailableToConsume) {
			// Esta habilitado para consumir => el consumidor ya puede tomar el valor del productor. 
			// El productor tiene que esperar que el consumidor lo tome antes de poner un nuevo valor.
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isAvailableToConsume = true;
		this.numero = numero;
		this.notify();
	}

}
