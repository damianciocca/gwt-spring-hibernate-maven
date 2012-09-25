package spring.ejemplos.dos.ioc.annotation.ejemplocompleto;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

/**
 * http://www.inmensia.com/articulos/spring/anotaciones_dependencias.html
 * http://blogs.sourceallies.com/2011/08/spring-injection-with-resource-and-autowired/#more-2350
 * @Inject, @Resource y @Autowired
 * 
 * @author dciocca
 */
public class Coche {
	
	private Motor motor;
	
	@Autowired
	private Rueda rueda;
	
	// Esta anotacion pertenece al estandar de java JSR 299 (java EE 6)
	// So in theory if you used @Inject you could replace spring with another DI framework e.g. Guice 
	// and inject your dependencies in the same way.
	// Esta anotación tiene el mismo comportamiento que la anterior @Autowired, aunque carece del 
	// parámetro required. La ventaja está en que pertenece a la especificación estándar de Java en 
	// vez de pertenecer a Spring.
	@Inject
	private Chasis chasis;
		
	public Motor getMotor() {
		return motor;
	}
	
	//La anotación @Required se aplica comúnmente sobre los DAOs a los que accede un servicio.
	@Required
	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	public Rueda getRueda() {
		return rueda;
	}

	public void setRueda(Rueda rueda) {
		this.rueda = rueda;
	}

	public Chasis getChasis() {
		return chasis;
	}

	public void setChasis(Chasis chasis) {
		this.chasis = chasis;
	}
	

}
