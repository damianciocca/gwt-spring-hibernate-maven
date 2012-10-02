package com.javacodegeeks.jaxwsspring.services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

/**
 * http://www.javacodegeeks.com/2010/11/jaxws-with-spring-and-maven-tutorial.html
 * 
 * @author Damian Ciocca
 */

@WebService(serviceName="GreetingService")
@SOAPBinding(style = Style.RPC, use = Use.LITERAL)
public class GreetingService {

	@WebMethod
	public String sayHello() {
		return "Hello from Greeting Service";
	}
	
}	

