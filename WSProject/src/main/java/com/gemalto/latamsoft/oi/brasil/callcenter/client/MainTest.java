package com.gemalto.latamsoft.oi.brasil.callcenter.client;

/**
 * wsimport -p com.gemalto.latamsoft.nuevatel.bolivia.cem.ws.client -keep http://localhost:8081/cem-ws-1.0.0-ALPHA01/DMService?wsdl
 * 
 * @author dciocca
 *
 */
public class MainTest {

	public static void main(String[] args) {

		RecuperarCompraAvulsaWsImplService helloService = new RecuperarCompraAvulsaWsImplService();
		RecuperarCompraAvulsaWs recuperarCompraAvulsaWsImplPort = helloService.getRecuperarCompraAvulsaWsImplPort();

		System.out.println("ANTES");
		recuperarCompraAvulsaWsImplPort.recuperarCompraAvulsa(new RecuperarCompraAvulsaRequestType());
		System.out.println("DESPUES");

	}

}
