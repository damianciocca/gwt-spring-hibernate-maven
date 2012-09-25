package spring.ejemplos.dos.ioc.xml.ejemplocompleto;

public class PizzeriaServiceImpl implements PizzeriaService{

	private PizzaBean pizza;
	
	public PizzeriaServiceImpl() {
		super();
		System.out.println("Se inicializa el objeto mediante el constructor => PizzeriaServiceImpl");
	}

	public void dispatch() {
		
		System.out.println("dispatching...." + pizza);
	}

	public PizzaBean getPizza() {
		return pizza;
	}

	public void setPizza(PizzaBean pizza) {
		this.pizza = pizza;
	}
	
}
