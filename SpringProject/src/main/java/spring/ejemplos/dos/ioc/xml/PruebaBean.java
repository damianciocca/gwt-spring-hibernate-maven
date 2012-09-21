package spring.ejemplos.dos.ioc.xml;

public class PruebaBean {
	
	private String name;
	
	

	public PruebaBean() {
		super();
		System.out.println("se crea la instancia... ");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
