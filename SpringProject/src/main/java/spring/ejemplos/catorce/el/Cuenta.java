package spring.ejemplos.catorce.el;

import org.springframework.beans.factory.annotation.Value;

public class Cuenta {
	
	// Aplicamos EL con un operador ternario comparando el valor de otro bean para setear
	// el valor de esta propiedad de este bean
	@Value("#{libro.price < 100 ? true : false}")
	private boolean warning;

	public boolean isWarning() {
		return warning;
	}

	public void setWarning(boolean warning) {
		this.warning = warning;
	}
	

}
