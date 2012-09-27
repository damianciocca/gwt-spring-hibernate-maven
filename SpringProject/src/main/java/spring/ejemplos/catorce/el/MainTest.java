package spring.ejemplos.catorce.el;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * http://www.inmensia.com/articulos/spring/spel_expression_language.html
 * http://www.inmensia.com/articulos/spring/spel_expresiones_basicas.html
 * http://www.mkyong.com/spring3/spring-el-regular-expression-example/
 * 
 * @author dciocca
 */
public class MainTest {
	
	public static void main(String arg[]){
		
		System.out.println("**********INICIALIZACION CONTEXTO SPRING*********");
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring/ejemplos/catorce/el/SpringIoC.xml");
		
		System.out.println("**********FIN INICIALIZACION CONTEXTO SPRING*********");
		
		Libro libro = context.getBean(Libro.class);
		
		System.out.println(libro.getOs());
		System.out.println(libro.getRandomValue());
		System.out.println(libro.isValidEmail());
		
		Cuenta cuenta = context.getBean(Cuenta.class);
		System.out.println("WARNING: " + cuenta.isWarning());
		
		
	}
}


