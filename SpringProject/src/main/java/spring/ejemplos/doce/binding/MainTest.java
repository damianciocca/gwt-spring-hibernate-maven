package spring.ejemplos.doce.binding;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * http://www.inmensia.com/articulos/spring/binding_converter_formatting.html
 * 
 * @author dciocca
 */
public class MainTest {
	
	public static void main(String arg[]){
		
		System.out.println("**********INICIALIZACION CONTEXTO SPRING*********");
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring/ejemplos/doce/binding/SpringIoC.xml");
		
		System.out.println("**********FIN INICIALIZACION CONTEXTO SPRING*********");
		
		Autor autor = context.getBean(Autor.class);
		Libro libro = context.getBean(Libro.class);
		
		BeanWrapper libroWrapper = new BeanWrapperImpl(libro);
		BeanWrapper autorWrapper = new BeanWrapperImpl(autor);
		
		autorWrapper.setPropertyValue("name", "NAMEEEEEEE");
		libroWrapper.setPropertyValue("title", "TITULOOOO");
		libroWrapper.setPropertyValue("autor", autorWrapper.getWrappedInstance());
		
		System.out.println(libroWrapper.getPropertyValue("title"));
		System.out.println(libroWrapper.getPropertyValue("autor.name"));
		
		
	}
}


