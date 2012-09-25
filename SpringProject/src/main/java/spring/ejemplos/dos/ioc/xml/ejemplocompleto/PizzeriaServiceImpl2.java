package spring.ejemplos.dos.ioc.xml.ejemplocompleto;

public abstract class PizzeriaServiceImpl2 implements PizzeriaService{
	
	
	public PizzeriaServiceImpl2() {
		super();
	}
	
	public void dispatch() {
        
		System.out.println("dispatching...." + createPizza());
	}
	
    public abstract PizzaBean createPizza();

}
