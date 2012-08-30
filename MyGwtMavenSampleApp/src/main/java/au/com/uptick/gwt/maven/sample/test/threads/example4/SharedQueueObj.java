package au.com.uptick.gwt.maven.sample.test.threads.example4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Objeto Cola que se comparte entre un thread productor (Productor1Thread)
 *  y un thread consumidor (ConsumidorThread).
 * 
 * @author dciocca
 *
 */
public class SharedQueueObj {
	
	Queue<Integer> cola = new LinkedList<Integer>();
	boolean isAvailableToConsume = false;
	
	public synchronized void putInteger(int numero){
		
		cola.add(numero);
		this.notify(); // Notificamos en caso que exista un consumidor que este esperando a tomar valores de la cola. 
	}
	
	public synchronized int getInteger(){
		
		while(this.cola.isEmpty()){
			// Mientras que la cola este vacia => el consumidor no puede tomar el valor de la cola.
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
		Integer numero = cola.remove();
		return numero;
	}

}
