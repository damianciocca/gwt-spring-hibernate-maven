package spring.ejemplos.seis.components.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LibroService {

	@Autowired
	@Qualifier("ldao")
	ILibroDao dao; 
	
	public LibroService() {
		super();
		System.out.println("Se inicializa el objeto mediante el constructor => LibroService");
	}

	public ILibroDao getDao() {
		return dao;
	}

	public void setDao(ILibroDao dao) {
		this.dao = dao;
	}
	
}
