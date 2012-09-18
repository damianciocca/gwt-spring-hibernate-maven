package spring.ejemplos.dos.ioc.annotation;

import org.springframework.stereotype.Component;

@Component("legajo")
/**
 * Inyeccion por CONSTRUCTOR + NOMBRE DISTINTO
 */
public class LegajoBean {
	
	private String numero;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "LegajoBean [numero=" + numero + "]";
	}
	
}
