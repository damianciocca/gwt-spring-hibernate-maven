package spring.ejemplos.diesiseis.transaction.annotation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class CuentaService {

	// Esta propiedad la va a injectar automaticamente ya que el DAO esta marcado con la anotacion 
	// @Repository y en el XML agregamos la linea que escanee los componentes (beans)
	// No importa que tenga otro nombre ya q la inyeccion la hace por tipo y no por nombre
	// El problema que podremos llegar a tener aca es que si tenemos mas de una misma implementacion
	// de IDao no va a saber cual inyectar y va a pinchar!!!
	@Autowired
	IDao dao;
	
	@Transactional(readOnly = true)
	public void transferir() {
		
		System.out.println("transferir.... INICIO");
		
		List<Customer> customers = dao.findAll();
		
		for (Customer customer : customers) {
			System.out.println("CUSTOMER: " + customer.getName());
		}
		
		System.out.println("transferir.... FIN");
		
	}
	
	@Transactional
	public void comprobarSaldo() {
		
		System.out.println("comprobarSaldo....");
		throw new RuntimeException();
	}

	
}
