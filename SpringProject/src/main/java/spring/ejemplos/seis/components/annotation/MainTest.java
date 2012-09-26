package spring.ejemplos.seis.components.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * http://www.inmensia.com/articulos/spring/anotaciones_componentes.html
 * 
 * @author dciocca
 *
 */
public class MainTest {
	
	public static void main(String arg[]){
		
		System.out.println("**********INICIALIZACION CONTEXTO SPRING*********");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/ejemplos/seis/components/annotation/SpringIoC.xml");
		
		System.out.println("**********FIN INICIALIZACION CONTEXTO SPRING*********");
		
		/**
		 * SALIDA POR CONSOLA:
		 * 
		 	**********INICIALIZACION CONTEXTO SPRING*********
			Sep 26, 2012 11:25:44 AM org.springframework.context.support.AbstractApplicationContext prepareRefresh
			INFO: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@1f436f5: startup date [Wed Sep 26 11:25:44 GMT-03:00 2012]; root of context hierarchy
			Sep 26, 2012 11:25:44 AM org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
			INFO: Loading XML bean definitions from class path resource [spring/ejemplos/seis/components/annotation/SpringIoC.xml]
			Sep 26, 2012 11:25:44 AM org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider registerDefaultFilters
			INFO: JSR-330 'javax.inject.Named' annotation found and supported for component scanning
			Sep 26, 2012 11:25:45 AM org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor <init>
			INFO: JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
			Sep 26, 2012 11:25:45 AM org.springframework.beans.factory.support.DefaultListableBeanFactory preInstantiateSingletons
			INFO: Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@c5495e: defining beans [estanteria,libro,ldao,libroService,org.springframework.context.annotation.internalConfigurationAnnotationProcessor,org.springframework.context.annotation.internalAutowiredAnnotationProcessor,org.springframework.context.annotation.internalRequiredAnnotationProcessor]; root of factory hierarchy
			Se inicializa el objeto mediante el constructor => Estanteria
			Se inicializa el objeto mediante el constructor => Libro
			Se inicializa el objeto mediante el constructor => LibroDao
			Se inicializa el objeto mediante el constructor => LibroService
			**********FIN INICIALIZACION CONTEXTO SPRING*********
		 */
		
	}
}


