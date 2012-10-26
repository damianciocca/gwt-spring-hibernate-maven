package com.gemalto.latansoft.ws;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface SearchPlanets {
	
	@WebResult(name="planets")
	List<Planeta> retrievePlanets(@WebParam(name="name") String name);

}
