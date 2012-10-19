package spring.ejemplos.diecisiete.ws.cxf.client.cxfgeneratedcode;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.2.3
 * Fri Oct 19 13:58:10 ART 2012
 * Generated source version: 2.2.3
 * 
 */
 
@WebService(targetNamespace = "http://ws.cxf.com/", name = "HelloWS")
@XmlSeeAlso({ObjectFactory.class})
public interface HelloWS {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "decirHola", targetNamespace = "http://ws.cxf.com/", className = "spring.ejemplos.diecisiete.ws.cxf.client.cxfgeneratedcode.DecirHola")
    @ResponseWrapper(localName = "decirHolaResponse", targetNamespace = "http://ws.cxf.com/", className = "spring.ejemplos.diecisiete.ws.cxf.client.cxfgeneratedcode.DecirHolaResponse")
    @WebMethod
    public java.lang.String decirHola(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebResult(name = "persona", targetNamespace = "")
    @RequestWrapper(localName = "buscarPersona", targetNamespace = "http://ws.cxf.com/", className = "spring.ejemplos.diecisiete.ws.cxf.client.cxfgeneratedcode.BuscarPersona")
    @ResponseWrapper(localName = "buscarPersonaResponse", targetNamespace = "http://ws.cxf.com/", className = "spring.ejemplos.diecisiete.ws.cxf.client.cxfgeneratedcode.BuscarPersonaResponse")
    @WebMethod
    public spring.ejemplos.diecisiete.ws.cxf.client.cxfgeneratedcode.Persona buscarPersona(
        @WebParam(name = "legajo", targetNamespace = "")
        long legajo
    );
}
