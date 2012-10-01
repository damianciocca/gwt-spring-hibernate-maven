package spring.ejemplos.quince.aop.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * http://www.dosideas.com/wiki/Interceptores_Con_Spring
 * 
 * @author dciocca
 *
 */
public class MainTest {
	
	public static void main(String arg[]){
		
		System.out.println("**********INICIALIZACION CONTEXTO SPRING*********");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/ejemplos/quince/aop/annotation/SpringIoC.xml");
		
		System.out.println("**********FIN INICIALIZACION CONTEXTO SPRING*********");
		
		PaisService service = context.getBean(PaisService.class);
		
		service.findName("nameeeeee");
		
	}
}


