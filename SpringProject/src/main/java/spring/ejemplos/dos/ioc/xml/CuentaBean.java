package spring.ejemplos.dos.ioc.xml;

public class CuentaBean {
	
	private String number;
	private String name;
	
	public CuentaBean() {
		super();
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

	@Override
	public String toString() {
		return "CuentaBean [number=" + number + ", name=" + name + "]";
	}
	
}
