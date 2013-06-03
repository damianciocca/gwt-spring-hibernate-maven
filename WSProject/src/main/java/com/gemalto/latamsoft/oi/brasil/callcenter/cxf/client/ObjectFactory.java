
package com.gemalto.latamsoft.oi.brasil.callcenter.cxf.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.gemalto.latamsoft.oi.brasil.callcenter.cxf.client package. 
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

    private final static QName _RecuperarCompraAvulsaResponse_QNAME = new QName("http://ws.callcenter.brasil.oi.latamsoft.gemalto.com/", "RecuperarCompraAvulsaResponse");
    private final static QName _RecuperarCompraAvulsa_QNAME = new QName("http://ws.callcenter.brasil.oi.latamsoft.gemalto.com/", "RecuperarCompraAvulsa");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.gemalto.latamsoft.oi.brasil.callcenter.cxf.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RecuperarCompraAvulsaResponseType }
     * 
     */
    public RecuperarCompraAvulsaResponseType createRecuperarCompraAvulsaResponseType() {
        return new RecuperarCompraAvulsaResponseType();
    }

    /**
     * Create an instance of {@link RecuperarCompraAvulsaRequestType }
     * 
     */
    public RecuperarCompraAvulsaRequestType createRecuperarCompraAvulsaRequestType() {
        return new RecuperarCompraAvulsaRequestType();
    }

    /**
     * Create an instance of {@link RecuperarCompraAvulsa }
     * 
     */
    public RecuperarCompraAvulsa createRecuperarCompraAvulsa() {
        return new RecuperarCompraAvulsa();
    }

    /**
     * Create an instance of {@link RecuperarCompraAvulsaDataType }
     * 
     */
    public RecuperarCompraAvulsaDataType createRecuperarCompraAvulsaDataType() {
        return new RecuperarCompraAvulsaDataType();
    }

    /**
     * Create an instance of {@link RecuperarCompraAvulsaResponse }
     * 
     */
    public RecuperarCompraAvulsaResponse createRecuperarCompraAvulsaResponse() {
        return new RecuperarCompraAvulsaResponse();
    }

    /**
     * Create an instance of {@link ResponseControlTypeCompraAvulsa }
     * 
     */
    public ResponseControlTypeCompraAvulsa createResponseControlTypeCompraAvulsa() {
        return new ResponseControlTypeCompraAvulsa();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecuperarCompraAvulsaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.callcenter.brasil.oi.latamsoft.gemalto.com/", name = "RecuperarCompraAvulsaResponse")
    public JAXBElement<RecuperarCompraAvulsaResponse> createRecuperarCompraAvulsaResponse(RecuperarCompraAvulsaResponse value) {
        return new JAXBElement<RecuperarCompraAvulsaResponse>(_RecuperarCompraAvulsaResponse_QNAME, RecuperarCompraAvulsaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecuperarCompraAvulsa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.callcenter.brasil.oi.latamsoft.gemalto.com/", name = "RecuperarCompraAvulsa")
    public JAXBElement<RecuperarCompraAvulsa> createRecuperarCompraAvulsa(RecuperarCompraAvulsa value) {
        return new JAXBElement<RecuperarCompraAvulsa>(_RecuperarCompraAvulsa_QNAME, RecuperarCompraAvulsa.class, null, value);
    }

}
