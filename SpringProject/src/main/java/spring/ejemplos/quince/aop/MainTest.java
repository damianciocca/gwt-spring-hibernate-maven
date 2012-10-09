package spring.ejemplos.quince.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * http://www.inmensia.com/articulos/spring/aop_introduccion.html
 * http://www.inmensia.com/articulos/spring/aop_poincuts_advices.html
 * 
 * http://www.epidataconsulting.com/tikiwiki/tiki-index.php?page=Spring+AOP#
 * 
 * @author dciocca
 *
 */
public class MainTest {
	
	public static void main(String arg[]){
		
		System.out.println("**********INICIALIZACION CONTEXTO SPRING*********");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/ejemplos/quince/aop/SpringIoC.xml");
		
		System.out.println("**********FIN INICIALIZACION CONTEXTO SPRING*********");
		
		Secretaria secretaria = context.getBean(Secretaria.class);
		
		secretaria.conversacion();
		secretaria.inDespacho();
		secretaria.holaMundo("Damian");
		secretaria.pellizco();
		
		
	}
}


