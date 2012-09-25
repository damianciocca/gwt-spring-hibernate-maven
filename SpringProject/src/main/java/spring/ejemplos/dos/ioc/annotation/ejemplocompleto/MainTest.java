package spring.ejemplos.dos.ioc.annotation.ejemplocompleto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * http://stackoverflow.com/questions/7142622/what-is-the-difference-between-inject-and-autowired-in-spring-framework-which
 * 
 * @Resource	javax.annotation					Java
 * @Inject		javax.inject						Java
 * @Qualifier	javax.inject						Java
 * @Autowired	org.springframework.bean.factory	Spring
 * 
 * http://www.inmensia.com/articulos/spring/anotaciones_dependencias.html
 * 
 * @Required: Esta anotación permite indicar que una dependencia debe ser resuelta obligatoriamente en 
 * tiempo de configuración. Es decir, que una determinada propiedad de un bean debe tener un valor 
 * distinto de nulo al acabar de instanciarla.

 * @Autowired: Esta anotación permite el autodescubrimiento e inyección automática de dependencias. 
 * Resuelve el problema del apartado anterior, haciendo innecesario declarar de forma explícita las 
 * dependencias en el fichero XML de configuración, y además tiene la ventaja de que se puede 
 * aplicar sobre muchos de los elementos de una clase.

 * @Inject: Esta anotación tiene el mismo comportamiento que la anterior @Autowired, aunque carece 
 * del parámetro required. La ventaja está en que pertenece a la especificación estándar de Java en vez 
 * de pertenecer a Spring.
 * 
 * <dependency>
		<groupId>javax.inject</groupId>
		<artifactId>javax.inject</artifactId>
		<version>1</version>
   </dependency>
 *
 * @Resource: Esta anotación se utiliza para eliminar ambiguedades a la hora de inyectar dependencias 
 * automáticamente, sobre todo si se aplica la anotación @Autowired en propiedades que tienen como 
 * tipo una interface, ya que clases distintas pueden implementar una misma interface.
 * Pertenece a la especificación estándar de Java, en vez de a Spring, por lo que requiere añadir 
 * la misma dependencia de Maven indicada para la anotación @Inject.
 * 
 * @Qualifier: Esta anotación tiene un comportamiento similar a la anterior @Resource, pero utiliza los 
 * roles de los beans en vez de sus identificadores para resolver las dependencias Su uso más común es 
 * aplicarla usando el valor de alguna característica semántica de los beans definidos en la 
 * configuración. Vale, así dicho asusta un poco, pero la "característica semántica" es simplemente el 
 * valor de la etiqueta qualifier que tiene un bean dentro del fichero XML, y que se usa para indicar 
 * el "rol" que tiene un bean dentro de la aplicación.Esta anotación tiene un comportamiento similar a 
 * la anterior @Resource, pero utiliza los roles de los beans en vez de sus identificadores para 
 * resolver las dependencias.
 * Utilizando la anotación @Qualifier se puede eliminar la ambiguedad a la hora de resolver las 
 * dependencias de forma automática
 * 
 * @author dciocca
 *
 */
public class MainTest {
	
	public static void main(String arg[]){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/ejemplos/dos/ioc/annotation/ejemplocompleto/SpringIoC.xml");
		Coche coche = (Coche) context.getBean("coche");
		Motor motor = coche.getMotor();
		Rueda rueda = coche.getRueda();
		Chasis chasis = coche.getChasis();
		System.out.println("COCHE " + coche);
		System.out.println("MOTOR " + motor);
		System.out.println("RUEDA " + rueda);
		System.out.println("CHASIS " + chasis);
	
	}
}


