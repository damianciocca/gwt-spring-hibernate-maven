package au.com.uptick.gwt.maven.sample.test.arbol;

import java.util.ArrayList;
import java.util.List;

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
		Nodo cuatro = new Nodo(4, null);
		Nodo seis = new Nodo(6, null);
		Nodo nueve = new Nodo(9, null);
		lista1.add(cuatro);
		lista1.add(seis);
		lista1.add(nueve);

		List<Nodo> lista2 = new ArrayList<Nodo>();
		Nodo veinte = new Nodo(20, lista1);
		Nodo doce = new Nodo(12, null);
		Nodo cinco = new Nodo(5, null);
		lista2.add(veinte);
		lista2.add(doce);
		lista2.add(cinco);

		Nodo root = new Nodo(50, lista2);
		obtenerPromedio(root);
	}

	public static float obtenerPromedio(Nodo root){

		List<Nodo> childs = root.getChilds();
		for (int i = 0; i <= childs.size(); i++){
			if (childs != null){
				System.out.println("===> " + childs.get(i).getValue());
				obtenerPromedio(childs.get(i));
			}
		}
		return 0;
	}


}
