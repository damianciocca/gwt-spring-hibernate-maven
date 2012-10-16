package com.cxf.ws.client;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cxf.ws.HelloWS;

/**
 * Otra forma de invocar al bean (que seria el WS) pero para nosotros es totalmente transparente
 * Esa es la magia de esto que te lo wrappea como si fuese un bean
 * 
 * http://unpocodejava.wordpress.com/2010/03/30/web-services-con-cxf/
 * http://www.dosideas.com/noticias/java/396-servicios-web-con-apache-cxf.html
 * http://unpocodejava.wordpress.com/2010/03/30/web-services-con-cxf/
 * 
 * @author dciocca
 *
 */
public class MaintTest {

	public static void main(String arg[]){
		
		System.out.println("**********INICIALIZACION CONTEXTO SPRING*********");
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-Test.xml");
		
		HelloWS ws = (HelloWS) context.getBean("holaMundoCliente");
		
		System.out.println(ws.decirHola("Damian"));
		
		System.out.println("**********FIN INICIALIZACION CONTEXTO SPRING*********");
		
		
		
		
	}
}
