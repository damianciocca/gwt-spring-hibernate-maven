package com.gemalto.latamsoft.oi.brasil.callcenter.client;

import javax.xml.ws.BindingProvider;

/**
 * wsimport -p com.gemalto.latamsoft.oi.brasil.callcenter.client -keep http://localhost:8081/oi-brasil-callcenter-soap-ws/services/RecuperarCompraAvulsaWs?wsdl
 * 
 * @author dciocca
 *
 */
public class MainTest {

	public static void main(String[] args) {

		RecuperarCompraAvulsaWs_Service service = new RecuperarCompraAvulsaWs_Service();
		RecuperarCompraAvulsaWs port = service.getRecuperarCompraAvulsa();
		
		// To override the URL endpoint..
		BindingProvider bp = (BindingProvider)port;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8081/oi-brasil-callcenter-soap-ws/services/RecuperarCompraAvulsaWs");

		System.out.println("ANTES");
		port.recuperarCompraAvulsa(new RecuperarCompraAvulsaRequestType());
		System.out.println("DESPUES");

	}

}
