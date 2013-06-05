
package com.gemalto.latamsoft.oi.brasil.callcenter.cxf.client3;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.gemalto.latamsoft.oi.brasil.callcenter.cxf.client3 package. 
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

    private final static QName _RecuperarCompraAvulsaResponse_QNAME = new QName("http://alsb.telemar/xsd/RecuperarCompraAvulsaResponse", "RecuperarCompraAvulsaResponse");
    private final static QName _ResponseControl_QNAME = new QName("http://alsb.telemar/soap/esb", "ResponseControl");
    private final static QName _RecuperarCompraAvulsaRequest_QNAME = new QName("http://alsb.telemar/xsd/RecuperarCompraAvulsaRequest", "RecuperarCompraAvulsaRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.gemalto.latamsoft.oi.brasil.callcenter.cxf.client3
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
     * Create an instance of {@link RecuperarCompraAvulsaDataType }
     * 
     */
    public RecuperarCompraAvulsaDataType createRecuperarCompraAvulsaDataType() {
        return new RecuperarCompraAvulsaDataType();
    }

    /**
     * Create an instance of {@link RecuperarCompraAvulsa }
     * 
     */
    public RecuperarCompraAvulsa createRecuperarCompraAvulsa() {
        return new RecuperarCompraAvulsa();
    }

    /**
     * Create an instance of {@link ResponseControlTypeCompraAvulsa }
     * 
     */
    public ResponseControlTypeCompraAvulsa createResponseControlTypeCompraAvulsa() {
        return new ResponseControlTypeCompraAvulsa();
    }

    /**
     * Create an instance of {@link RecuperarCompraAvulsaResponse }
     * 
     */
    public RecuperarCompraAvulsaResponse createRecuperarCompraAvulsaResponse() {
        return new RecuperarCompraAvulsaResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecuperarCompraAvulsaResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://alsb.telemar/xsd/RecuperarCompraAvulsaResponse", name = "RecuperarCompraAvulsaResponse")
    public JAXBElement<RecuperarCompraAvulsaResponseType> createRecuperarCompraAvulsaResponse(RecuperarCompraAvulsaResponseType value) {
        return new JAXBElement<RecuperarCompraAvulsaResponseType>(_RecuperarCompraAvulsaResponse_QNAME, RecuperarCompraAvulsaResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseControlTypeCompraAvulsa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://alsb.telemar/soap/esb", name = "ResponseControl")
    public JAXBElement<ResponseControlTypeCompraAvulsa> createResponseControl(ResponseControlTypeCompraAvulsa value) {
        return new JAXBElement<ResponseControlTypeCompraAvulsa>(_ResponseControl_QNAME, ResponseControlTypeCompraAvulsa.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecuperarCompraAvulsaRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://alsb.telemar/xsd/RecuperarCompraAvulsaRequest", name = "RecuperarCompraAvulsaRequest")
    public JAXBElement<RecuperarCompraAvulsaRequestType> createRecuperarCompraAvulsaRequest(RecuperarCompraAvulsaRequestType value) {
        return new JAXBElement<RecuperarCompraAvulsaRequestType>(_RecuperarCompraAvulsaRequest_QNAME, RecuperarCompraAvulsaRequestType.class, null, value);
    }

}
