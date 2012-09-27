package spring.ejemplos.trece.formatting;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.ejemplos.trece.formatting.number.Cuenta;

/*
 * http://www.inmensia.com/articulos/spring/binding_converter_formatting.html
 * 
 * @author dciocca
 */
public class MainTest {
	
	public static void main(String arg[]){
		
		System.out.println("**********INICIALIZACION CONTEXTO SPRING*********");
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring/ejemplos/trece/formatting/SpringIoC.xml");
		
		System.out.println("**********FIN INICIALIZACION CONTEXTO SPRING*********");
		
		Libro libro = context.getBean(Libro.class);
		
		System.out.println("FECHA FORMATEADA: " + libro.getDate());
		
		Cuenta cuenta = context.getBean(Cuenta.class);
		
		cuenta.setAmount(new BigDecimal(10));
		cuenta.setInterest(new BigDecimal(1000));
		cuenta.setInterestRate(new BigDecimal(9089));
		cuenta.setFechaPublicacion(new Date());
		
		System.out.println(cuenta.getAmount());
		System.out.println(cuenta.getInterest());
		System.out.println(cuenta.getInterestRate());
		System.out.println(cuenta.getFechaPublicacion());
		
	}
}


