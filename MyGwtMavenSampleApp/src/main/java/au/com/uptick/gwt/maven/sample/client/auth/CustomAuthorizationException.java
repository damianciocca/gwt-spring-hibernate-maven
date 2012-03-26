package au.com.uptick.gwt.maven.sample.client.auth;

import java.io.Serializable;

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
