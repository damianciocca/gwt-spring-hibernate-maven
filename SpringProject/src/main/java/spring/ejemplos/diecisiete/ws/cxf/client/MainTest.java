package spring.ejemplos.diecisiete.ws.cxf.client;

import org.springframework.context.ApplicationContext;
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
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/ejemplos/diecisiete/ws/cxf/client/appContext.xml");
		
		System.out.println("**********FIN INICIALIZACION CONTEXTO SPRING*********");
		
		// ALTERNATIVA 1: Version simplificada del cliente WS - Solo un pojo pelado con la anotacion webservice 
		
//		spring.ejemplos.diecisiete.ws.cxf.client.HelloWS ws1 = (spring.ejemplos.diecisiete.ws.cxf.client.HelloWS) context.getBean("holaMundoCliente");
//		
//		ws1.decirHola("Damian");
//		
//		ws1.buscarPersona(12);
		
		// ALTERNATIVA 2: Generando las clases cliente mediante cxf (wsdl2java)
		
		spring.ejemplos.diecisiete.ws.cxf.client.cxfgeneratedcode.HelloWS ws2 = (spring.ejemplos.diecisiete.ws.cxf.client.cxfgeneratedcode.HelloWS) context.getBean("holaMundoCliente");
		
		ws2.decirHola("Damian");
		
		ws2.buscarPersona(12);
		
		// ALTERNATIVA 3:Generando las clases cliente mediante JDK 6 (wsimport)
		
//		spring.ejemplos.diecisiete.ws.cxf.client.jaxwsgeneratedcode.HelloWS ws3 = (spring.ejemplos.diecisiete.ws.cxf.client.jaxwsgeneratedcode.HelloWS) context.getBean("holaMundoCliente");
//		
//		ws3.decirHola("Damian");
//		
//		ws3.buscarPersona(12);
//		
		
		
		
	}
}


