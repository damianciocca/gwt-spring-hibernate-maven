package au.com.uptick.gwt.maven.sample.client.auth.exceptions;

import java.io.Serializable;

/**
 * Para que esta excepcion pueda hacer rollback, vamos a necesitar agregar en cada metodo
 * transaccion, el atributo rollbackFor
 * 
 * Otra opcion es que esta excepcion extienda de RuntimExcepcion.
 * 
 * @author dciocca
 *
 */
public class SecurityException extends Exception implements Serializable{

	public SecurityException() {
		super();
	}

	public SecurityException(String paramString, Throwable paramThrowable) {
		super(paramString, paramThrowable);
	}

	public SecurityException(String paramString) {
		super(paramString);
	}

	public SecurityException(Throwable paramThrowable) {
		super(paramThrowable);
	}

}
