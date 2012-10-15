package com.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * 
 * http://maksim.sorokin.dk/it/2011/01/20/jax-ws-web-services-maven-tomcat/
 * http://www.mkyong.com/webservices/jax-ws/deploy-jax-ws-web-services-on-tomcat/
 * 
 * @author dciocca
 *
 */

@WebService
@SOAPBinding(style = Style.RPC)
public class HelloWS {

	@WebMethod
	public String sayHello(String name) {
		
		if (name == null) {
			return "Hello";
		}
		
		System.out.println("ENTROOOOOOOOOOOOOO");

		return "Hello, " + name + "!";
	}
}
