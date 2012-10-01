package spring.ejemplos.quince.aop;

public class Secretaria {

	public Secretaria() {
		System.out.println("Se crea la instancia => Secretaria");
	}
	public String conversacion(){
		System.out.println("bla, bla, bla");
		return "bla, bla, bla";	
	}
	public String inDespacho(){
		System.out.println("in despacho....");
		return "in despacho....";
	}
	public String pellizco(){
		throw new RuntimeException("¡pillín!");
	}
	
	public String holaMundo(String nombre){
		System.out.println("Hola " + nombre);
		return "Hola " + nombre;
	}

}
