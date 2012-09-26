package spring.ejemplos.siete.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Esta anotacion @Configuration es que NO requiere crear un fichero applicationContext.xml 
 * para que Spring funcione.
 * Es decir, el archivo XML sera esta clase
 *
 */
@Configuration
public class AppConfig {
	
	// Es igual a tener en el XML: 
	// <bean id="empleado" class="spring.ejemplos.siete.configuration.EmpleadoBean"/>
	@Bean(name="empleado")	
	public EmpleadoBean getEmpleado(){
		
		return new EmpleadoBean();
	}

}
