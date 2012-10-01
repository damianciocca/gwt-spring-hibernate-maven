package spring.ejemplos.quince.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect
public class LogInterceptor {
	
    public LogInterceptor() {
		super();
		System.out.println("Inicializamos LogInterceptor");
	}

    @Before("execution(* spring.ejemplos.quince.aop.annotation.*.*(..))")
	public void loguear() {
		System.out.println("<<ASPECT>> loguear: se está por ejecutar un servicio!");
	}
}
