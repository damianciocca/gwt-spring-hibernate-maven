package spring.ejemplos.dos.ioc.annotation;

import org.springframework.stereotype.Component;

@Component
/**
 *  * Inyeccion por METODO
 */
public class PersonaBean {
	
	private String name;

	public PersonaBean() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PersonaBean [name=" + name + "]";
	}

}
