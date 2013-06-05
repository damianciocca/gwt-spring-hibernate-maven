package com.gemalto.latamsoft.oi.brasil.callcenter.ws;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;


public class MainTest {
	
	public static void main(String args[]) throws ServiceException, RemoteException{
		
		RecuperarCompraAvulsaWsImplServiceLocator locator = new RecuperarCompraAvulsaWsImplServiceLocator();
		
		RecuperarCompraAvulsaWs port = null;
		locator.setRecuperarCompraAvulsaWsImplPortEndpointAddress("http://localhost:8081/oi-brasil-callcenter-soap-ws/services/RecuperarCompraAvulsaWs");
//		try {
//			port = locator.getRecuperarCompraAvulsaWsImplPort(new URL("http://localhost:8081/oi-brasil-callcenter-soap-ws/services/RecuperarCompraAvulsaWs"));
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		port = locator.getRecuperarCompraAvulsaWsImplPort();
		System.out.println(locator.getRecuperarCompraAvulsaWsImplPortAddress());
		RecuperarCompraAvulsaRequestType req = new RecuperarCompraAvulsaRequestType();
		req.setUsuario("user");
		req.setSenha("pass");
		req.setTransacao("12121212");
		req.setMsisdn("5712345789");
		RecuperarCompraAvulsaResponseType result = port.recuperarCompraAvulsa(req);
		
	}
	
}
