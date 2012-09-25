package spring.ejemplos.dos.ioc.xml.ejemplocompleto;

public abstract class PizzeriaServiceImpl2 implements PizzeriaService{
	
	public void init(){
		System.out.println("Se inicializa el objeto mediante el metodo init() => PizzeriaServiceImpl2");
	}
	
	public PizzeriaServiceImpl2() {
		super();
		System.out.println("Se inicializa el objeto mediante el constructor => PizzeriaServiceImpl2");
	}
	
	public void dispatch() {
        
		System.out.println("dispatching...." + createPizza());
	}
	
    public abstract PizzaBean createPizza();

}
