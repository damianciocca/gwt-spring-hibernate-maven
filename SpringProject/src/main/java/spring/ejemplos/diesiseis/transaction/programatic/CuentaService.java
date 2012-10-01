package spring.ejemplos.diesiseis.transaction.programatic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class CuentaService {

	// Esta propiedad la va a injectar automaticamente ya que esta definida en el XML.
	// No importa que tenga otro nombre en el XML ya q la inyeccion la hace por tipo y no por nombre
	@Autowired
	TransactionTemplate tx;

	// Esta propiedad la va a injectar automaticamente ya que el DAO esta marcado con la anotacion 
	// @Repository y en el XML agregamos la linea que escanee los componentes (beans)
	// No importa que tenga otro nombre ya q la inyeccion la hace por tipo y no por nombre
	// El problema que podremos llegar a tener aca es que si tenemos mas de una misma implementacion
	// de IDao no va a saber cual inyectar y va a pinchar!!!
	@Autowired
	IDao dao;
	
	public void transferir() {
		
		System.out.println("transferir.... INICIO");
		
		// TRANSACCION PROGRAMATICAMENTE
		List<Customer> customers = tx.execute(new TransactionCallback<List<Customer>>() {

			public List<Customer> doInTransaction(TransactionStatus arg0) {
				
				return dao.findAll();
			}
		});
		
		for (Customer customer : customers) {
			System.out.println("CUSTOMER NAME " + customer.getName());
			
		}
		System.out.println("transferir.... FIN");
		
	}
	
	public void comprobarSaldo() {
		
		System.out.println("comprobarSaldo....");
		throw new RuntimeException();
	}

	
}
