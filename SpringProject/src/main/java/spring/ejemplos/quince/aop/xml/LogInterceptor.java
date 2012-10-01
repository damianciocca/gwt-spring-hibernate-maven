package spring.ejemplos.quince.aop.xml;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogInterceptor implements MethodInterceptor {
	
	
    public LogInterceptor() {
		super();
		System.out.println("Inicializamos LogInterceptor");
	}

	public Object invoke(MethodInvocation invocation) throws Throwable {
    	
        System.out.println("Iniciando llamada");
        Object rval = invocation.proceed();
        System.out.println("Finalizando llamada");
        return rval;
    }

}
