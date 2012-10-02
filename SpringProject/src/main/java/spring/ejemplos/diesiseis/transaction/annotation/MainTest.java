package spring.ejemplos.diesiseis.transaction.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * http://www.inmensia.com/articulos/spring/transacciones_configuracion_anotaciones.html
 * http://springinpractice.com/2008/03/18/annotation-based-transactions-in-spring/
 * 
 * Las implementaciones por defecto de la interface PlatformTransactionManager son JtaTransactionManager 
 * y DataSourceTransactionManager.
 * 
 * JtaTransactionManager es un gestor de transacciones que implementa JTA, ya sea utilizando la implementación 
 * de un servidor de aplicaciones J2EE, o utilizando una implementación local de JTA embebida dentro de la 
 * propia aplicación. Resulta apropiado para trabajar con transacciones distribuidas que acceden a 
 * distintos recursos, o para gestionar transacciones que actúan sobre los recursos controlados por 
 * un servidor de aplicaciones, como una origen de datos JDBC accedido a través de JNDI por ejemplo.
 * 
 * DataSourceTransactionManager por su parte es más apropiado para un simple origen de datos JDBC. 
 * Esta clase es capaz de trabajar en cualquier entorno con virtualmente cualquier driver JDBC estándar.
 * 
 * Spring permite definir como debe realizarse la gestión de las transacciones de forma declarativa, utilizando 
 * los conceptos de la programación orientada a aspectos, al tiempo que ofrece la anotación @Transactional que 
 * permite simplificar sobremanera la configuración.
 * 
 * @author dciocca
 */
public class MainTest {
	
	public static void main(String[] args){
		
		System.out.println("**********INICIALIZACION CONTEXTO SPRING*********");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/ejemplos/diesiseis/transaction/annotation/SpringIoC.xml");
		
		System.out.println("**********FIN INICIALIZACION CONTEXTO SPRING*********");
		
		CuentaService service = context.getBean(CuentaService.class);
		
		service.transferir();
		service.comprobarSaldo();
		
	}

}
