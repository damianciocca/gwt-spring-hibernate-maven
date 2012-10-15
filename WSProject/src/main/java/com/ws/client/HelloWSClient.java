package com.ws.client;

/**
 * wsimport -p nombrepaquete -keep http://localhost:8080/WSProject/HelloWS?wsdl
 * 
 * Con este comando generamos las clases cliente para poder conectarnos con el WS:
 * 		HelloWS.java 
 * 		HelloWSService.java
 * 
 * @author dciocca
 *
 */
public class HelloWSClient {
	
	public static void main(String args[]){
		
		// 1. Creamos el service generado por el wsimport
		HelloWSService helloService = new HelloWSService();
		
		// 2. Obtenemos el HelloWS generado por el wsimport a traves del servicio
		HelloWS hello = helloService.getHelloWSPort();
 
		// 3. Invocamos al WS propiamente dicho
		System.out.println(hello.sayHello("Damian Ciocca"));
	}

}
