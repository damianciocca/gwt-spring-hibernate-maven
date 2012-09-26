package spring.ejemplos.siete.configuration;


public class DireccionBean {
	
	private String calle;
	private String altura;
	
	public DireccionBean() {
		super();
		System.out.println("Se inicializa el objeto mediante el constructor => DireccionBean");
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


}
