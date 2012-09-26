package spring.ejemplos.seis.components.annotation;

import javax.inject.Named;

// Esta anotación es similar a la @Component, pero pertenece a la especificación estándar de 
// Java, en vez de a Spring, por lo que requiere añadir la misma dependencia de Maven 
// indicada para la anotación @Inject.
@Named
public class Libro {

	public Libro() {
		super();
		System.out.println("Se inicializa el objeto mediante el constructor => Libro");
	}

	
}
