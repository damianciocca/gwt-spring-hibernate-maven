package com.gemalto.latansoft.ws;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context-test.xml"})
public class PlanetaTest {

	@Autowired
	private PlanetaJDBCResolver planetaJDBCResolver;

	@Test
	public void iniciarJob() throws Exception {

		List<Planeta> result = planetaJDBCResolver.retrievePlanetByName("Otra Prueba");

		for (Planeta planeta : result) {
			System.out.println("Planeta codigo : " + planeta.getCodigo() + " - diametro: " + planeta.getDiametro() );
		}
	}
}
