package spring.ejemplos.seis.components.annotation;

import org.springframework.stereotype.Repository;

@Repository("ldao")
public class LibroDao implements ILibroDao{

	public LibroDao() {
		super();
		System.out.println("Se inicializa el objeto mediante el constructor => LibroDao");
	}
	
	

}
