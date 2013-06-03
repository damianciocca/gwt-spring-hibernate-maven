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

		RecuperarCompraAvulsaWsImplService helloService = new RecuperarCompraAvulsaWsImplService();
		RecuperarCompraAvulsaWs recuperarCompraAvulsaWsImplPort = helloService.getRecuperarCompraAvulsaWsImplPort();
		
		BindingProvider bp = (BindingProvider)recuperarCompraAvulsaWsImplPort;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8081/oi-brasil-callcenter-soap-ws/services/RecuperarCompraAvulsaWs");

		System.out.println("ANTES");
		recuperarCompraAvulsaWsImplPort.recuperarCompraAvulsa(new RecuperarCompraAvulsaRequestType());
		System.out.println("DESPUES");

	}

}
