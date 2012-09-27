package spring.ejemplos.once.validators.annotations;

import java.util.List;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;

/**
 * http://static.springsource.org/spring/docs/3.0.0.RC3/reference/html/ch05s07.html
 * 
 * During validation values bound to field of form data objects are checked for value conditions. 
 * Annotations are used to specifiy what Validator and arguments should be applied to each 
 * field. Spring MVC 3.0 supports the Java standard for Bean Validation JSR 303. 
 * Hibernate Validator is the reference implementation, and is used by Spring MVC. 
 * Both API and implementation must be on the classpath of the application for it to be used.
 * 
 * http://www.jpalace.org/docs/tutorials/spring/mvc_21.html
 * 
 * @author dciocca
 *
 */
public class MainTest {

	public static void main(String arg[]){

		System.out.println("**********INICIALIZACION CONTEXTO SPRING*********");

		ApplicationContext context = new ClassPathXmlApplicationContext("spring/ejemplos/once/validators/annotations/SpringIoC.xml");

		System.out.println("**********FIN INICIALIZACION CONTEXTO SPRING*********");

		Libro libro = (Libro) context.getBean("libro");
		LibroService service = context.getBean(LibroService.class);
		MessageSource messages = (MessageSource) context.getBean("messageSource");

		Validator validator = service.getValidator();
		BeanPropertyBindingResult errors = new BeanPropertyBindingResult(libro, "libro1");
		validator.validate(libro,errors);
		
		List<ObjectError> allErrors = errors.getAllErrors();
		for (ObjectError error : allErrors) {
			System.out.println(error.getCode() + " " + error.getDefaultMessage());
			//System.out.println( messages.getMessage(error.getCode(), null, Locale.US) );
		}
	}
}


