package com.cxf.ws.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cxf.ws.HelloWS;
import com.cxf.ws.Persona;


/**
 * IMPORTANTE:
 * 
 * Deberemos contar con una interfaz Java que cumpla con la firma del servicio web. En este ejemplo, 
 * usaremos la misma clase HelloWS.java como interfaz, pero podría ser otra interfaz (siempre y cuando cumpla con la firma).
 * 
 * http://unpocodejava.wordpress.com/2010/03/30/web-services-con-cxf/
 * http://www.dosideas.com/noticias/java/396-servicios-web-con-apache-cxf.html
 * http://unpocodejava.wordpress.com/2010/03/30/web-services-con-cxf/
 * 
 * NOTA: Se neceista tener levantado el WS en el localhost;8080
 * 
 * @author dciocca
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-Test.xml"})
public class HolaMundoTest {
	
	@Autowired
    private HelloWS instance;
 
    @Test
    public void testDecirHola() {
    	
        String nombre = "Zim";
        String expResult = "Hola, " + nombre;
 
        String result = instance.decirHola(nombre);
 
        assertEquals(expResult, result);
    }
    
    @Test
    public void testBuscarPersona() {
    	
        long legajo = 29L;
 
        Persona result = instance.buscarPersona(legajo);
 
        assertNotNull(result);
        assertEquals(legajo, result.getLegajo());
        assertNotNull(result.getNombre());
        assertTrue(!result.getNombre().isEmpty());
    }

}
