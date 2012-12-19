package com.gemalto.latamsoft.nuevatel.bolivia.cem.ws.client;

/**
 * wsimport -p com.gemalto.latamsoft.nuevatel.bolivia.cem.ws.client -keep http://localhost:8081/cem-ws-1.0.0-ALPHA01/DMService?wsdl
 * 
 * @author dciocca
 *
 */
public class MainTest {

	public static void main(String[] args) {

		DMServiceImplService helloService = new DMServiceImplService();
		DMService ws = helloService.getDMServiceImplPort();

		try {
			Capabilities capabilities = ws.getCapabilities("");
			System.out.println(capabilities.getManufacturerName());
			System.out.println(capabilities.getModelName());
		} catch (Exception e) {
			
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}
		

		try {
			Capabilities capabilities = ws.getCapabilities("1");
			System.out.println(capabilities.getManufacturerName());
			System.out.println(capabilities.getModelName());
		} catch (Exception e) {
			
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}

	}

}
