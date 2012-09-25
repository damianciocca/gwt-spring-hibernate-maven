package spring.ejemplos.dos.ioc.xml.ejemplocompleto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * http://www.inmensia.com/articulos/spring/beans_inyeccion_metodos.html
 * 
 * @author dciocca
 *
 */
public class MainTest {
	
	public static void main(String arg[]){
		
		System.out.println("**********INICIALIZACION CONTEXTO SPRING*********");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/ejemplos/dos/ioc/xml/ejemplocompleto/SpringIoC.xml");
		
		System.out.println("**********FIN INICIALIZACION CONTEXTO SPRING*********");
		
		System.out.println("******** EJEMPLO 1*******************");
		// De esta manera, siempre vamos a despachar la misma pizza (objetos iguales).
		/**
		 * dispatching....spring.ejemplos.dos.ioc.xml.ejemplocompleto.PizzaBean@1b383e9
		 * dispatching....spring.ejemplos.dos.ioc.xml.ejemplocompleto.PizzaBean@1b383e9
		 * dispatching....spring.ejemplos.dos.ioc.xml.ejemplocompleto.PizzaBean@1b383e9
		 * dispatching....spring.ejemplos.dos.ioc.xml.ejemplocompleto.PizzaBean@1b383e9
		 */
		PizzeriaServiceImpl pizzeria1 = (PizzeriaServiceImpl) context.getBean("pizzeria1");
		pizzeria1.dispatch();
		pizzeria1.dispatch();
		pizzeria1.dispatch();
		pizzeria1.dispatch();
		
		System.out.println("******** EJEMPLO 2*******************");
		// Si queremos despachar diferentes pizzas (objetos distintos)
		// NOTA: esto por si solo lanzara una excepcion
		// java.lang.ClassNotFoundException respecto a la clase net.sf.cglib.proxy.CallbackFilter
		// El error es debido a que Spring realiza la inyección del método a muy bajo nivel, manipulando directamente 
		// el bytecode de las clases a través de CGLIB, que es una librería que permite hacer esto precisamente.
		/**
		 * se crea la instancia => PizzaBean()
		 * dispatching....spring.ejemplos.dos.ioc.xml.ejemplocompleto.PizzaBean@12a3722
		 * se crea la instancia => PizzaBean()
		 * dispatching....spring.ejemplos.dos.ioc.xml.ejemplocompleto.PizzaBean@89cf1e
		 * se crea la instancia => PizzaBean()
		 * dispatching....spring.ejemplos.dos.ioc.xml.ejemplocompleto.PizzaBean@17ce4e7
		 * se crea la instancia => PizzaBean()
		 * dispatching....spring.ejemplos.dos.ioc.xml.ejemplocompleto.PizzaBean@982589
		 */
		PizzeriaServiceImpl2 pizzeria2 = (PizzeriaServiceImpl2) context.getBean("pizzeria2");
		pizzeria2.dispatch();
		pizzeria2.dispatch();
		pizzeria2.dispatch();
		pizzeria2.dispatch();
		
		
		
	}
}


