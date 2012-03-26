package au.com.uptick.gwt.maven.sample.client;

import au.com.uptick.gwt.maven.sample.client.auth.CustomAuthorizationException;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.InvocationException;

/**
 * Custom AsyncCallbak para el manejo de las excepciones conocidas y actue en consecuencia
 * @author dciocca
 * @param <T>
 */
public abstract class MyAsyncCallback<T> implements AsyncCallback<T>{

	public void onFailure(Throwable caught) {

		if (caught instanceof CustomAuthorizationException) {
			// TODO armar un popup  
			// WindowHelper.showUnExpectedErrorMessage("No se pudo acceder al servidor", "No se pudo acceder al servidor [" + caught.getMessage() + "]"); 
			System.out.println("TODO lanzar un popup que maneje esta excepcion => CustomAuthorizationException");
		} else if (caught instanceof InvocationException) {
			// TODO armar un popup  
			// WindowHelper.showUnExpectedErrorMessage("No se pudo acceder al servidor", "No se pudo acceder al servidor [" + caught.getMessage() + "]"); 
			System.out.println("TODO lanzar un popup que maneje esta excepcion => InvocationException");
		} else {
			onError(caught, false);
		}
	}

	/**
	 * Este metodo sera lanzado ante cualquier excepcion y nos advertira (mediante el parametro alreadyHandledError) si
	 * ya fue manejada por el MyAsyncCallback o no
	 * 
	 * @param caught
	 * @param alreadyHandledError
	 */
	public abstract void onError(Throwable caught, boolean alreadyHandledError);

}
