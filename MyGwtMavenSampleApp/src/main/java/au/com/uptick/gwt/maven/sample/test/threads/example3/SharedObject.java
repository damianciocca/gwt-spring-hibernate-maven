package au.com.uptick.gwt.maven.sample.test.threads.example3;

public class SharedObject {
	
	int numero = 1;
	boolean isAvailableToConsume = false;

	/**
	 * Este metodo sera invocado por el consumidor
	 * @return
	 */
	public synchronized int getNumero() {
		
		while(!isAvailableToConsume){
			// No esta habilitado para consumir => el consumidor no puede tomar el valor del productor.	
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("CONSUMIDOR SACA " + numero);
		isAvailableToConsume = false;
		this.notify(); //notificamos al productor que puede colocar un nuevo entero
		return numero;
	}
	
	/**
	 * Este metodo sera invocado por el productor
	 * @param numero
	 */
	public synchronized void setNumero(int numero) {
		
		while(isAvailableToConsume){
			// Esta habilitado para consumir => el consumidor ya puede tomar el valor del productor. 
			// El productor tiene que esperar que el consumidor lo tome antes de poner un nuevo valor.	
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("PRODUCTOR PONE " + numero);
		isAvailableToConsume = true;
		this.numero = numero;
		this.notify(); //notificamos al consumidor que puede tomar un nuevo entero
	}

	public synchronized boolean isAvailable() {
		return isAvailableToConsume;
	}

	public synchronized void setAvailable(boolean isAvailable) {
		this.isAvailableToConsume = isAvailable;
	}

	
	
}
