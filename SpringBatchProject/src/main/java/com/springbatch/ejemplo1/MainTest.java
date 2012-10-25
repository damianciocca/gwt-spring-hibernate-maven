package com.springbatch.ejemplo1;

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
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("com/springbatch/appContext-spring-batch.xml");
		
		System.out.println("**********FIN INICIALIZACION CONTEXTO SPRING*********");
		
		
		
	}
}


