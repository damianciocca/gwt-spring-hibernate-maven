package au.com.uptick.gwt.maven.sample.server.auth;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Esta clase se encargara de interceptar las llamadas a cada metodo.
 * @author dciocca
 *
 */
public class CustomAuthenticationInterceptor implements MethodInterceptor {

	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		
		System.out.println("CustomAuthenticationInterceptor Method name : " + methodInvocation.getMethod().getName());
		System.out.println("CustomAuthenticationInterceptor Method arguments : " + Arrays.toString(methodInvocation.getArguments()));
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    System.out.println("user logged: " + auth.getName());
 
		try {
			Object result = methodInvocation.proceed();
			return result;
		} catch (Throwable e) {
			if (e instanceof AccessDeniedException){
				System.out.println("CustomAuthenticationInterceptor access denied exception");
				throw new SecurityException(e);
			}
			throw e;
		}
	}

}
