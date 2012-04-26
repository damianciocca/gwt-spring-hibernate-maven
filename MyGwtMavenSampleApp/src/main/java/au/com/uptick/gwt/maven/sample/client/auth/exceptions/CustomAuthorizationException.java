package au.com.uptick.gwt.maven.sample.client.auth.exceptions;

import java.io.Serializable;

/**
 * Al extender de RuntimException automaticamente hace ROOLBACK sin se tiene que
 * utilizar la anotacion @transaction rollbackFor=
 * 
 * @author dciocca
 */
public class CustomAuthorizationException extends RuntimeException implements Serializable {

	public CustomAuthorizationException() {
		super();
	}

	public CustomAuthorizationException(String paramString, Throwable paramThrowable) {
		super(paramString, paramThrowable);
	}

	public CustomAuthorizationException(String paramString) {
		super(paramString);
	}

	public CustomAuthorizationException(Throwable paramThrowable) {
		super(paramThrowable);
	}
}
