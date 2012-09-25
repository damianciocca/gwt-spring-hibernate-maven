package spring.ejemplos.dos.ioc.xml;

public class EjemploBean {
	
	private String name;

	public EjemploBean() {
		super();
		System.out.println("se crea la instancia => EjemploBean()");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
