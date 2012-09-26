package spring.ejemplos.nueve.eventos;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.ejemplos.nueve.eventos.customevent.SaludarEventPublisher;

/**
 * http://www.inmensia.com/articulos/spring/applicationcontext_eventos.html
 * http://www.tutorialspoint.com/spring/event_handling_in_spring.htm
 * http://www.tutorialspoint.com/spring/custom_events_in_spring.htm
 * 
	1	ContextRefreshedEvent
		This event is published when the ApplicationContext is either initialized or refreshed. 
		This can also be raised using the refresh() method on the ConfigurableApplicationContext 
		interface.
		
	2	ContextStartedEvent
		This event is published when the ApplicationContext is started using the start() method on
		the ConfigurableApplicationContext interface. You can poll your database or you can 
		re/start any stopped application after receiving this event.
		
	3	ContextStoppedEvent
		This event is published when the ApplicationContext is stopped using the stop() method 
		on the ConfigurableApplicationContext interface. You can do required housekeep work after 
		receiving this event.
		
	4	ContextClosedEvent
		This event is published when the ApplicationContext is closed using the close() method 
		on the ConfigurableApplicationContext interface. A closed context reaches its end of life; 
		it cannot be refreshed or restarted.
		
	5	RequestHandledEvent
		This is a web-specific event telling all beans that an HTTP request has been serviced.
		
 * @author dciocca
 *
 */
public class MainTest {
	
	public static void main(String arg[]){
		
		System.out.println("**********INICIALIZACION CONTEXTO SPRING*********");
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring/ejemplos/nueve/eventos/SpringIoC.xml");
		
		System.out.println("**********FIN INICIALIZACION CONTEXTO SPRING*********");
		
		context.start();
		
		SaludarEventPublisher publisher = (SaludarEventPublisher) context.getBean("saludarPublisher");
		publisher.publish("evento custom 1");
		publisher.publish("evento custom 2");
		publisher.publish("evento custom 3");
		
		context.stop();
		
		/**
		 * SALIDA POR CONSOLA:
		 * 
		 *  **********INICIALIZACION CONTEXTO SPRING*********
			Sep 26, 2012 2:12:47 PM org.springframework.context.support.AbstractApplicationContext prepareRefresh
			INFO: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@1f436f5: startup date [Wed Sep 26 14:12:47 GMT-03:00 2012]; root of context hierarchy
			Sep 26, 2012 2:12:47 PM org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
			INFO: Loading XML bean definitions from class path resource [spring/ejemplos/nueve/eventos/SpringIoC.xml]
			Sep 26, 2012 2:12:47 PM org.springframework.beans.factory.support.DefaultListableBeanFactory preInstantiateSingletons
			INFO: Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@b8f8eb: defining beans [saludarListener,saludarPublisher,startContextListener,appListener]; root of factory hierarchy
			AppListener => class org.springframework.context.event.ContextRefreshedEvent
			**********FIN INICIALIZACION CONTEXTO SPRING*********
			
			StartContextListener => class org.springframework.context.event.ContextStartedEvent
			AppListener => class org.springframework.context.event.ContextStartedEvent
			SaludarListener => class spring.ejemplos.nueve.eventos.customevent.SaludarEvent
			SaludarListener => evento custom 1
			AppListener => class spring.ejemplos.nueve.eventos.customevent.SaludarEvent
			SaludarListener => class spring.ejemplos.nueve.eventos.customevent.SaludarEvent
			SaludarListener => evento custom 2
			AppListener => class spring.ejemplos.nueve.eventos.customevent.SaludarEvent
			SaludarListener => class spring.ejemplos.nueve.eventos.customevent.SaludarEvent
			SaludarListener => evento custom 3
			AppListener => class spring.ejemplos.nueve.eventos.customevent.SaludarEvent
			AppListener => class org.springframework.context.event.ContextStoppedEvent
			
		 */
		
	}
}


