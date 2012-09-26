package spring.ejemplos.ocho.i18n;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * http://www.inmensia.com/articulos/spring/anotaciones_configuracion.html
 * 
 * @author dciocca
 *
 */
public class MainTest {
	
	public static void main(String arg[]){
		
		System.out.println("**********INICIALIZACION CONTEXTO SPRING*********");
		
		MessageSource messages = new ClassPathXmlApplicationContext("spring/ejemplos/ocho/i18n/SpringIoC.xml");
		
		System.out.println("**********FIN INICIALIZACION CONTEXTO SPRING*********");
		
		// locale US
		Locale localeUSA = new Locale("en_US");
		System.out.println("LOCALE: " + localeUSA);
		String message2 = messages.getMessage("saludo", new Object[]{"Damian"}, localeUSA);
		System.out.println("MENSAJE: " + message2);
		
		// locale US
		Locale localeES = new Locale("es_ES");
		System.out.println("LOCALE: " + localeES);
		String message3 = messages.getMessage("saludo", new Object[]{"Damian"}, localeES);
		System.out.println("MENSAJE: " + message3);
		
		
	}
}


