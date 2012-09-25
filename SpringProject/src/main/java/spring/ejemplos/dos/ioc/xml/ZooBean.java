package spring.ejemplos.dos.ioc.xml;

public class ZooBean {
	
	private PruebaBean bean;
	
	public ZooBean() {
		super();
		System.out.println("se crea la instancia => ZooBean()");
	}

	public PruebaBean getBean() {
		return bean;
	}

	public void setBean(PruebaBean bean) {
		this.bean = bean;
	}
	
}
