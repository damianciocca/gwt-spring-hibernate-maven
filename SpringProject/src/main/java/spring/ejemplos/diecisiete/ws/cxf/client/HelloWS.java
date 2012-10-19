package spring.ejemplos.diecisiete.ws.cxf.client;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * http://www.dosideas.com/noticias/java/396-servicios-web-con-apache-cxf.html
 * http://unpocodejava.wordpress.com/2010/03/30/web-services-con-cxf/
 * 
 * NOTA esta es una alternativa donde se genero una interface pelada y solo se le puso la anotacion
 * @Webservice... esta interface se la creo a mano sin utilizar el comando wsdl2java de CXF
 * 
 * @author dciocca
 *
 */
@WebService()
public interface HelloWS {

	String decirHola(String nombre);

	Persona buscarPersona(long legajo);

}
