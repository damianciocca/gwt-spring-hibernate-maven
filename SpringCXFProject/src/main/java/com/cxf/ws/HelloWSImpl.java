package com.cxf.ws;

import javax.jws.WebService;

/**
 * La anotacion @WebService(endpointInterface = "com.dosideas.cxf.HolaMundo") en esta clase le indica a Apache CXF 
 * cuál será la interfaz de este servicio web. Es la única anotación que se necesita agregar en la implementación.
 * 
 * @author dciocca
 *
 */
@WebService(endpointInterface = "com.cxf.ws.HelloWS")
public class HelloWSImpl implements HelloWS {

	@Override
	public String decirHola(String nombre) {

		System.out.println("INVOCANDO AL METODO decirHola del WS...");
		return "Hola, " + nombre;
	}

	@Override
	public Persona buscarPersona(long legajo) {

		System.out.println("INVOCANDO AL METODO buscarPersona del WS...");
		Persona persona = new Persona();
		persona.setLegajo(legajo);
		persona.setNombre("Mock de persona para el legajo " + legajo);
		return persona;
	}

}
