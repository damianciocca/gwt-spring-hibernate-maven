package spring.ejemplos.siete.configuration.model;

import org.springframework.stereotype.Component;

@Component("cuenta")
public class CuentaBean {
	
	private String number;
	private String name;
	
	public CuentaBean() {
		super();
		System.out.println("Se inicializa el objeto mediante el constructor => CuentaBean");
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
