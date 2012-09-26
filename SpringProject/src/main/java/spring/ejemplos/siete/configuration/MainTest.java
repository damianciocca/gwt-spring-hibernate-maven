package spring.ejemplos.siete.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.ejemplos.siete.configuration.model.CuentaBean;

/**
 * http://www.inmensia.com/articulos/spring/anotaciones_componentes.html
 * 
 * @author dciocca
 *
 */
public class MainTest {
	
	public static void main(String arg[]){
		
		System.out.println("**********INICIALIZACION CONTEXTO SPRING*********");
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		System.out.println("**********FIN INICIALIZACION CONTEXTO SPRING*********");
		
		EmpleadoBean empleadoBean1 = context.getBean(EmpleadoBean.class);
		System.out.println("Empleado`1: " + empleadoBean1);
		EmpleadoBean empleadoBean2 = (EmpleadoBean) context.getBean("empleado");
		System.out.println("Empleado 2: " + empleadoBean2);
		
		// Se registra en tiempo de ejecucion un nuevo bean al contexto de spring.
		context.register(DireccionBean.class);
		DireccionBean direccion = context.getBean(DireccionBean.class);
		System.out.println("Direccion: " + direccion);
		
		// Se obliga a escanear en ese paquete en busca de nuevos beans. En este ejemplo
		// se encontrara solo uno llamada CuentaBean
		context.scan("spring.ejemplos.siete.configuration.model");
		CuentaBean cuenta = (CuentaBean) context.getBean("cuenta");
		System.out.println("Cuenta: " + cuenta);
	}
}


