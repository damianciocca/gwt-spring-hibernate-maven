package spring.ejemplos.cuatro.factorymethod;

public class ServiceLocator {
	
	private static EmpleadoBean bean = new EmpleadoBean();
	
	private ServiceLocator(){
		
	}
	
	public EmpleadoBean createEmpleadoBeanServiceInstance(){
		
		System.out.println("ServiceLocator => createEmpleadoBeanServiceInstance()");
		return bean;
	}

}
