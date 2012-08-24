package au.com.uptick.gwt.maven.sample.test.arbol;

import java.util.ArrayList;
import java.util.List;

/**
 * VER http://sujitpal.blogspot.com.ar/2006/05/java-data-structure-generic-tree.html
 * 
 * @author Damian Ciocca
 *
 */
public class PromedioArbol {
	
	
	/**
	 * 2- Implementar el metodo  public float obtenerPromedio(Nodo root) para que devuelva el promedio de los valores
	 * de un arbol. ej Arbol de promedio 15.14

					50
			_______|_______
			|		|	   |
			20		12	   5
		_________
		|	|	|
		4	6	9

	 * @param arg
	 */
	public static void main(String arg[]){

		List<Nodo> lista1 = new ArrayList<Nodo>();
		Nodo cuatro = new Nodo(4, new ArrayList<Nodo>());
		Nodo seis = new Nodo(6, new ArrayList<Nodo>());
		Nodo nueve = new Nodo(9, new ArrayList<Nodo>());
		lista1.add(cuatro);
		lista1.add(seis);
		lista1.add(nueve);

		List<Nodo> lista2 = new ArrayList<Nodo>();
		Nodo veinte = new Nodo(20, lista1);
		Nodo doce = new Nodo(12, new ArrayList<Nodo>());
		Nodo cinco = new Nodo(5, new ArrayList<Nodo>());
		lista2.add(veinte);
		lista2.add(doce);
		lista2.add(cinco);

		Nodo root = new Nodo(50, lista2);
		obtenerPromedio(root);
		
	}
	
	public static float obtenerPromedio(Nodo root){
		
		List<Integer> values = obtenerValoresDelArbol(root, new ArrayList<Integer>());
		if (values.size() > 0){
			int suma = 0;
			for (Integer v : values) {
				suma = suma + v.intValue();
			}
			float promedio = suma / values.size();
			System.out.println("Promedio " + promedio);
			return promedio;
		}
		
		return 0;
	}
	
	private static List<Integer> obtenerValoresDelArbol(Nodo element, List<Integer> values) {

		values.add(element.getValue());
		System.out.println("VALOR: " + element.getValue());
		for (Nodo data : element.getChilds()) {
			obtenerValoresDelArbol(data, values);
		}

		return values;
	}


}
