package spring.ejemplos.quince.aop.xml;

import java.util.List;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;

/**
 * http://www.dosideas.com/wiki/Interceptores_Con_Spring
 * 
 * @author dciocca
 *
 */
public class MainTest {
	
	public static void main(String arg[]){
		
		System.out.println("**********INICIALIZACION CONTEXTO SPRING*********");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/ejemplos/quince/aop/xml/SpringIoC.xml");
		
		System.out.println("**********FIN INICIALIZACION CONTEXTO SPRING*********");
		
		PaisService service = context.getBean(PaisService.class);
		
		service.findName("nameeeeee");
		
	}
}


