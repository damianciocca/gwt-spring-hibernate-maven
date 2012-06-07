package au.com.uptick.gwt.maven.sample.client.app.utils.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtils {
	
	public static void main(String args[]){
		
		//a) dado un mensaje , obtener el inverso ( "abc" => "cba" )
		getInverso("HOLA MUNDO");
		
		//b) dado un listado de letras, verificar si la palabra se puede formar con dichas letras
		//   Por ejemplo la palbra "PEPE" se puede formar con el siguiente set de letras (P,P,E,E)
		char letras[] = {'P','E','P','E'};
		String palabra = "PEPE";
		sePuedeArmar(letras, palabra);

		//C) dadu un listao de letras y una letra, verificar si se encuentra dicha letra
		//   Por ejemplo, la letra A se encuentra en el listado (A,B,C,D)
		String[] let = {"A", "B", "C", "D"};	
		seEncuentraEn("A", let);
		
		String[] let2 = {"A", "B", "C", "D"};	
		seEncuentraEn2("R", let2);
		
		//D) dado una palabra larga y otra una palabra mas corta, verificar si se encuentra dicha palabra corta en la palabra mas larga
		//   Por ejemplo, la palabra raul se encuentra en la cadea "ASDRERAULGFGFGF"
		pertenece("pepe", "raulpepegomez");
		
		//E) Dado una palabra, verificar si la misma empieza con la letra A
		empiezaCon("ABRACADABRA" , "A");
		
		//F) Contar letras
		contarPalabras("ÜIOUIOPU");
		
		//G) Eliminar la K-esima palabra de una cadena
		eliminarFrase("RAULNEIRA", "NE");
		
		//f) Fibonacci
		fibonacci(20);
		
		int[] enteros = new int[10];
		
		for(int i = 0; i <= enteros.length - 1; i++){
			
			
		}
		
	}
	
	private static List<Long> fibonacci(int num){
		
		List<Long> result = new ArrayList<Long>();
		for (int i = 0; i <= num; i++){
			result.add(fib(i));
		}
		
		for(int i = 0; i < result.size(); i++ ){
			System.out.println(result.get(i));
		}
		
		return result;
	} 
	
	private static long fib(int n) {
        if (n <= 1) 
			return n;
		else 
			return fib(n-1) + fib(n-2);
    }
	
	private static void eliminarFrase(String cadena, String palabra){
		
		CharSequence frase = palabra;
		if (cadena.contains(frase)){
			String resultado = cadena.replaceAll(palabra, "");
			System.out.println(resultado);
		} else {
			System.out.println("No se puede eliminar ya que no existe la palabra en al cadena");
		}
		
	}
	
	private static void contarPalabras(String palabra){
		
		char[] letras =  palabra.toCharArray();
		System.out.println(letras.length);
		
	}
	
	private static void empiezaCon(String palabra, String letra){
		
		char letraInicial = palabra.charAt(0);
		if(letra.equals(String.valueOf(letraInicial))){
			System.out.println("Empieza con la letra " + letra );
		} else {
			System.out.println("NO empieza con la letra " + letra );
		}
		
	}
	
	private static void pertenece(String palabra1, String palabra2){
		
		CharSequence charseq = palabra1; 
		if (palabra2.contains(charseq)){
			System.out.println("La contiene...");
		} else {
			System.out.println("No La contiene...");
		}
		
	}
	
	private static void seEncuentraEn2(String letra, String[] letras){
		
		List<String> cadena = Arrays.asList(letras);
		
		if (cadena.contains(letra)){
			System.out.println("Se encuentra..");	
		} else {
			System.out.println("NO Se encuentra..");
		}
	}
	
	private static void seEncuentraEn(String letra, String[] letras){
		
		boolean seEncuentra = false;
		for(int i = 0; i <= letras.length -1; i++){
			if(letras[i] == letra){
				seEncuentra = true;
				break;
			}
		}
		
		if (seEncuentra){
			System.out.println("Se encuentra..");
		} else {
			System.out.println("NO Se encuentra..");
		}
		
	}
	
	private static void getInverso(String cadena){
		
		StringBuffer sb = new StringBuffer();
		for(int i = cadena.length() - 1; i >= 0; i--){
			sb.append(cadena.charAt(i));
		}
		System.out.println(sb.toString());
	}
	
	private static void sePuedeArmar(char[] letras, String palabra){

		boolean sePuedeFormar = false;
		int letrasFrecuencias[] = new int[26];
		for (int i = 0; i <= letras.length - 1; i++){
			char letra = letras[i];
			int ascii = (int)letra - 63;
			letrasFrecuencias[ascii] = letrasFrecuencias[ascii] + 1;  		
		}
		
		for (int i = 0; i <= palabra.length() - 1; i++){
			
			char letra = letras[i];
			int ascii = (int)letra - 63;
			if ( letrasFrecuencias[ascii] > 0 ){
				letrasFrecuencias[ascii] = letrasFrecuencias[ascii] - 1;
			} else {
				sePuedeFormar = false;
				break;
			}
		}
		
		if (sePuedeFormar){
			System.out.println("Se pudo formar...!!!");
		} else {
			System.out.println("No se puede formar...");
		}
	}

}
