package spring.ejemplos.cinco.pluginsfactorias;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * http://www.inmensia.com/articulos/spring/beans_instanciacion_dependencias.html
 * 
 * @author dciocca
 *
 */
public class MainTest {
	
	public static void main(String arg[]){
		
		System.out.println("**********INICIALIZACION CONTEXTO SPRING*********");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/ejemplos/cinco/pluginsfactorias/SpringIoC.xml");
		
		System.out.println("**********FIN INICIALIZACION CONTEXTO SPRING*********");
		
		PruebaBean bean1 = (PruebaBean) context.getBean("pruebaFactory");
		
		System.out.println("PruebaBean1 => " + bean1);
		
		PruebaBean bean2 = (PruebaBean) context.getBean("pruebaFactory");
		
		System.out.println("PruebaBean2 => " + bean2);
		
		// Por su parte, para acceder a la fábrica en si misma, hay que anteponer un ampersand al 
		// nombre (como con los punteros en C):
		PruebaFactoryBean factoryBean = (PruebaFactoryBean) context.getBean("&pruebaFactory");
		
		System.out.println("FactoryBean => " + factoryBean);
		
		
	}
}


