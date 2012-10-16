package com.cxf.ws;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * http://www.dosideas.com/noticias/java/396-servicios-web-con-apache-cxf.html
 * http://unpocodejava.wordpress.com/2010/03/30/web-services-con-cxf/
 * 
 * @author dciocca
 *
 */
@WebService
public interface HelloWS {

	String decirHola(String nombre);

	@WebResult(name="persona")
	Persona buscarPersona(@WebParam(name="legajo") long legajo);

}
