package spring.ejemplos.dos.ioc.xml;

public class CuentaBean {
	
	private String number;
	private String name;
	
	public CuentaBean() {
		super();
		System.out.println("se crea la instancia => CuentaBean()");
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
