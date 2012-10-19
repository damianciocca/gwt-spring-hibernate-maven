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
		
//		spring.ejemplos.diecisiete.ws.cxf.client.HelloWS ws1 = (spring.ejemplos.diecisiete.ws.cxf.client.HelloWS) context.getBean("holaMundoCliente");
//		
//		ws1.decirHola("Damian");
//		
//		ws1.buscarPersona(12);
		
		spring.ejemplos.diecisiete.ws.cxf.client.cxfgeneratedcode.HelloWS ws2 = (spring.ejemplos.diecisiete.ws.cxf.client.cxfgeneratedcode.HelloWS) context.getBean("holaMundoCliente");
		
		ws2.decirHola("Damian");
		
		ws2.buscarPersona(12);
		
		
		
	}
}


