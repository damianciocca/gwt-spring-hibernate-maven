package spring.ejemplos.dos.ioc.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	
public static void main(String arg[]){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/ejemplos/dos/ioc/annotation/SpringIoC.xml");
		EmpleadoBean empleado = (EmpleadoBean) context.getBean("empleadoBean");
		CuentaBean cuenta = empleado.getCuenta();
		DireccionBean direccion = empleado.getDireccion();
		LegajoBean legajo = empleado.getLegajoBean();
		PersonaBean personaBean = empleado.getPersonaBean();
		System.out.println("Empleado  => " + empleado);
		System.out.println("Cuenta 	  => " + cuenta);
		System.out.println("direccion => " + direccion);
		System.out.println("legajo	  => " + legajo);
		System.out.println("persona	  => " + personaBean);
	}
}


