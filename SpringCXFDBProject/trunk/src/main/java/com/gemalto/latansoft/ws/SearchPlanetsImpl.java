package com.gemalto.latansoft.ws;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

@WebService(endpointInterface = "com.gemalto.latansoft.ws.SearchPlanets")
public class SearchPlanetsImpl implements SearchPlanets{

	@Autowired
	private PlanetaJDBCResolver resolver;
	
	@Override
	public List<Planeta> retrievePlanets(String name) {
		
		System.out.println("RETRIEVING FROM WS....");
		List<Planeta> result = resolver.retrievePlanetByName(name);
		for (Planeta planeta : result) {
			System.out.println("Planeta codigo : " + planeta.getCodigo() + " - diametro: " + planeta.getDiametro() );
		}
		System.out.println("END OF EXCECUTION");
		return result;
	}

	
}
