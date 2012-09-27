package spring.ejemplos.once.validators;

import java.util.List;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;

/**
 * http://www.inmensia.com/articulos/spring/validadores.html
 * http://www.roseindia.net/tutorial/spring/spring3/ioc/springvalidation.html
 * 
 * @author dciocca
 *
 */
public class MainTest {
	
	public static void main(String arg[]){
		
		System.out.println("**********INICIALIZACION CONTEXTO SPRING*********");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/ejemplos/once/validators/SpringIoC.xml");
		
		System.out.println("**********FIN INICIALIZACION CONTEXTO SPRING*********");
		
		Libro libro = (Libro) context.getBean("libro");
		MessageSource messages = (MessageSource) context.getBean("messageSource");
		
		LibroValidator validator = new LibroValidator();
		/**
		 * La clase BeanPropertyBindingResult es un recurso necesario que se introduce ahora 
		 * para poder ejecutar el proceso de validación, pero que se discutirá en otro 
		 * capítulo relativo al Binding. Su propósito es extraer las propiedades del objeto 
		 * dado para que se les pueda asociar directamente códigos de error.
		 */
		BeanPropertyBindingResult errors = new BeanPropertyBindingResult(libro, "libro");
		
		ValidationUtils.invokeValidator(validator, libro, errors);
		
		List<ObjectError> allErrors = errors.getAllErrors();
		for (ObjectError error : allErrors) {
			//System.out.println(error.getCode());
			System.out.println( messages.getMessage(error.getCode(), null, Locale.US) );
		}
		
	}
}


