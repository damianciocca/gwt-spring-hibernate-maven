package spring.ejemplos.seis.components.annotation;

import org.springframework.stereotype.Component;

// Anotacion generica que permite que este bean sea manejado por el contexto de spring
// Es como declararlo en el XML mediante la etiqueta <bean id= .....>
@Component
public class Estanteria {

	public Estanteria() {
		super();
		System.out.println("Se inicializa el objeto mediante el constructor => Estanteria");
	}

	
}
