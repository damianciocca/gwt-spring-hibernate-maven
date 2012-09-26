package spring.ejemplos.dos.ioc.annotation.ejemplocompleto;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

/**
 * http://www.inmensia.com/articulos/spring/anotaciones_dependencias.html
 * http://blogs.sourceallies.com/2011/08/spring-injection-with-resource-and-autowired/#more-2350
 * @Inject, @Resource y @Autowired
 * 
 * @author dciocca
 */
public class Coche {
	
	// Esta inyeccion se aplica por XML pero tiene la anotacion Required que obliga a que se le inyecte un valor
	// Esta dependencia debe ser resuelta obligatoriamente en tiempo de configuración
	private Motor motor;
	
	// Resuelve el problema anterior, haciendo innecesario declarar de forma explícita las dependencias en 
	// el fichero XML de configuración. Esta anotacion se puede utilizar sobre una propiedad (habiando colocado los setters y getters),
	// sobre el constructor y sobre un metodo cualquiera.
	@Autowired
	private Rueda rueda;
	
	// Esta anotacion pertenece al estandar de java JSR 330 (java EE 6)
	// So in theory if you used @Inject you could replace spring with another DI framework e.g. Guice 
	// and inject your dependencies in the same way.
	// Esta anotacion tiene el mismo comportamiento que la anterior @Autowired, aunque carece del 
	// parametro required. La ventaja esta en que pertenece a la especificacion estandar de Java en 
	// vez de pertenecer a Spring.
	@Inject
	private Chasis chasis;
	
	// IMPORTANTE: Como tenemos dos objetos q implementan Pieza, en este caso Spring no sabe cual de los dos injectar
	// No unique bean of type [spring.ejemplos.dos.ioc.annotation.ejemplocompleto.Pieza] is defined: expected single matching bean but found 2: [volante, espejo]
	// Solucion 1: En caso que el nombre de la propiedad sea igual al del XML, lo va a inyectar correctamente => En este caso deberia ser "volante"
	// Solucion 2: Utilizando la anotacion @Resource o @Qualifier para diferenciar uno de otro
	@Autowired
	@Qualifier("volante") // Esta anotacion puede ser la de spring o la de javax.inject (jee 6)
	private Pieza volante1;
	
	// Idem al caso anterior.
	@Autowired
	@Qualifier("espejo")
	private Pieza espejo1;
		
	public Motor getMotor() {
		return motor;
	}
	
	//La anotacion @Required se aplica comunmente sobre los DAOs a los que accede un servicio.
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

	public Pieza getVolante1() {
		return volante1;
	}

	public void setVolante1(Pieza volante1) {
		this.volante1 = volante1;
	}

	public Pieza getEspejo1() {
		return espejo1;
	}

	public void setEspejo1(Pieza espejo1) {
		this.espejo1 = espejo1;
	}

}
