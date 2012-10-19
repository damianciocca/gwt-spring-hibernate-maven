
package spring.ejemplos.diecisiete.ws.cxf.client.cxfgeneratedcode;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the spring.ejemplos.diecisiete.ws.cxf.client.cxfgeneratedcode package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _BuscarPersona_QNAME = new QName("http://ws.cxf.com/", "buscarPersona");
    private final static QName _DecirHola_QNAME = new QName("http://ws.cxf.com/", "decirHola");
    private final static QName _DecirHolaResponse_QNAME = new QName("http://ws.cxf.com/", "decirHolaResponse");
    private final static QName _BuscarPersonaResponse_QNAME = new QName("http://ws.cxf.com/", "buscarPersonaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: spring.ejemplos.diecisiete.ws.cxf.client.cxfgeneratedcode
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DecirHola }
     * 
     */
    public DecirHola createDecirHola() {
        return new DecirHola();
    }

    /**
     * Create an instance of {@link DecirHolaResponse }
     * 
     */
    public DecirHolaResponse createDecirHolaResponse() {
        return new DecirHolaResponse();
    }

    /**
     * Create an instance of {@link BuscarPersonaResponse }
     * 
     */
    public BuscarPersonaResponse createBuscarPersonaResponse() {
        return new BuscarPersonaResponse();
    }

    /**
     * Create an instance of {@link Persona }
     * 
     */
    public Persona createPersona() {
        return new Persona();
    }

    /**
     * Create an instance of {@link BuscarPersona }
     * 
     */
    public BuscarPersona createBuscarPersona() {
        return new BuscarPersona();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarPersona }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.cxf.com/", name = "buscarPersona")
    public JAXBElement<BuscarPersona> createBuscarPersona(BuscarPersona value) {
        return new JAXBElement<BuscarPersona>(_BuscarPersona_QNAME, BuscarPersona.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DecirHola }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.cxf.com/", name = "decirHola")
    public JAXBElement<DecirHola> createDecirHola(DecirHola value) {
        return new JAXBElement<DecirHola>(_DecirHola_QNAME, DecirHola.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DecirHolaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.cxf.com/", name = "decirHolaResponse")
    public JAXBElement<DecirHolaResponse> createDecirHolaResponse(DecirHolaResponse value) {
        return new JAXBElement<DecirHolaResponse>(_DecirHolaResponse_QNAME, DecirHolaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarPersonaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.cxf.com/", name = "buscarPersonaResponse")
    public JAXBElement<BuscarPersonaResponse> createBuscarPersonaResponse(BuscarPersonaResponse value) {
        return new JAXBElement<BuscarPersonaResponse>(_BuscarPersonaResponse_QNAME, BuscarPersonaResponse.class, null, value);
    }

}
