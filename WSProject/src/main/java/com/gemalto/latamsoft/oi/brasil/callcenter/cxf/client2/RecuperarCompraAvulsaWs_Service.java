
/*
 * 
 */

package com.gemalto.latamsoft.oi.brasil.callcenter.cxf.client2;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.2.3
 * Wed Jun 05 17:04:38 ART 2013
 * Generated source version: 2.2.3
 * 
 */


@WebServiceClient(name = "RecuperarCompraAvulsaWs", 
                  wsdlLocation = "http://localhost:8081/oi-brasil-callcenter-soap-ws/services/RecuperarCompraAvulsaWs?wsdl",
                  targetNamespace = "http://alsb.telemar/xsd") 
public class RecuperarCompraAvulsaWs_Service extends Service {

    public final static URL WSDL_LOCATION;
    public final static QName SERVICE = new QName("http://alsb.telemar/xsd", "RecuperarCompraAvulsaWs");
    public final static QName RecuperarCompraAvulsa = new QName("http://alsb.telemar/xsd", "RecuperarCompraAvulsa");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8081/oi-brasil-callcenter-soap-ws/services/RecuperarCompraAvulsaWs?wsdl");
        } catch (MalformedURLException e) {
            System.err.println("Can not initialize the default wsdl from http://localhost:8081/oi-brasil-callcenter-soap-ws/services/RecuperarCompraAvulsaWs?wsdl");
            // e.printStackTrace();
        }
        WSDL_LOCATION = url;
    }

    public RecuperarCompraAvulsaWs_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public RecuperarCompraAvulsaWs_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public RecuperarCompraAvulsaWs_Service() {
        super(WSDL_LOCATION, SERVICE);
    }

    /**
     * 
     * @return
     *     returns RecuperarCompraAvulsaWs
     */
    @WebEndpoint(name = "RecuperarCompraAvulsa")
    public RecuperarCompraAvulsaWs getRecuperarCompraAvulsa() {
        return super.getPort(RecuperarCompraAvulsa, RecuperarCompraAvulsaWs.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns RecuperarCompraAvulsaWs
     */
    @WebEndpoint(name = "RecuperarCompraAvulsa")
    public RecuperarCompraAvulsaWs getRecuperarCompraAvulsa(WebServiceFeature... features) {
        return super.getPort(RecuperarCompraAvulsa, RecuperarCompraAvulsaWs.class, features);
    }

}
