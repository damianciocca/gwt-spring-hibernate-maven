package spring.ejemplos.dos.ioc.annotation;

import org.springframework.stereotype.Component;

@Component
/**
 * Inyeccion por SETTER
 */
public class DireccionBean {
	
	private String calle;
	private String altura;
	
	public DireccionBean() {
		super();
	}

	public DireccionBean(String calle, String altura) {
		this.calle = calle;
		this.altura = altura;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		return "DireccionBean [calle=" + calle + ", altura=" + altura + "]";
	}
	

}
