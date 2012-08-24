package au.com.uptick.gwt.maven.sample.test.refactorizacion;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FactorizarTest {

	/**
	 * 1- Implementar el metodo public Map<Integer, Integer> factorizar(int n)
	 * 	  de la clase Factorizador que devuelve en un mapa los factores donde:
	 * 	  clave/valor = {nroPrimo;exponente}
	 * 
	 * Ejemplos de resultados: 
	 * 
	 * factorizar(15) = 3^1 * 5^1 
	 * factorizar(100)= 2^2 * 5^2
	 * 
	 * 	 Numeros primos = Un número primo es un número entero mayor que 1 que sólo es dividido exactamente por 1 y él mismo	
	 * 					  Ej. 2, 3, 5, 7, 11, 13, 17.
	 *   Si queremos factorizar el 100 tenemos que ir dividiendolo por el menor n primo hasta que la division no me de resto 0, en
	 *   ese caso, pasamos al siguiente n primo y volvemos a dividir y asi sucesivamente.
	 *     
	 *   100 / 2 	= 50 (resto 0)
	 *   50  / 2	= 25 (resto 0)	
	 *   25  / 2 	= 12.5 (resto no es 0)
	 *   25  / 3	= 8.33 (resto no es 0)
	 *   25  / 5	= 5  (resto 0)
	 *   5   / 5	= 1  (resto 0)
	 *   1 					
	 *   
	 * @param args
	 */
	public static void main(String args[]) {
		
		Map<Integer, Integer> factorizacion = factorizar(12);
		
		Set<Integer> keySet = factorizacion.keySet();
		for (Integer key : keySet) {
			System.out.println(key + " => " + factorizacion.get(key));
		}
		System.out.println("FIN");


	}
	
	public static Map<Integer, Integer> factorizar(int n){
		
		Map<Integer, Integer> result = new LinkedHashMap<Integer, Integer>();
		
		if (n == 1){
			result.put(1, 1);
		}
		
		// Obtenemos el primer n primo.
		int numeroPrimo = getPrimoFrom(1, n);
		
		while(n > 1){
			
			int numDividido = n / numeroPrimo;

			// si el resto de la division es cero
			if (n % numeroPrimo == 0){
				
				n = numDividido;
				
				// Agregamos el valor en el mapa
				if (result.containsKey(numeroPrimo)){
					result.put(numeroPrimo, result.get(numeroPrimo) + 1);
				} else {
					result.put(numeroPrimo, 1);
				}
				
			} else {
				// En caso que no sea cero, vamos a tener que probar de dividir el numero con el siguiente n primo
				numeroPrimo = getPrimoFrom(numeroPrimo, n);
			}
		}
		
		return result;
	}
	
	/**
	 * Metodo que te devuelve el siguiente primo a partir de un primo dado.
	 * 
	 * @param primoStart
	 * @return
	 */
	private static int getPrimoFrom(int primoStart, int primoEnd){
		
		int start = primoStart + 1;
		
		for (int i = start; i <= primoEnd; i++) {
			
			if (esPrimo(i)){
				return i;
			}
		}
		
		return 0;
	}	
	
	private static boolean esPrimo(int numero){
		
		  int contador = 2;
		  boolean primo=true;
		  while ((primo) && (contador!=numero)){
		    if (numero % contador == 0)
		      primo = false;
		    contador++;
		  }
		  return primo;
		}

}
