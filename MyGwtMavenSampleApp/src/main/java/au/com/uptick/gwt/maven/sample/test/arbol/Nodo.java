package au.com.uptick.gwt.maven.sample.test.arbol;

import java.util.List;

public class Nodo {
	
	int value;
	List<Nodo> childs;
	
	public Nodo(int valor, List<Nodo> hijos) {
		super();
		this.value = valor;
		this.childs = hijos;
	}


	public int getValue() {
		return value;
	}

	public List<Nodo> getChilds() {
		return childs;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setChilds(List<Nodo> childs) {
		this.childs = childs;
	}

	

}
