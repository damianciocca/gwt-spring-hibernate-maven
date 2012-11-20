package com.gemalto.latamsoft.vtr.chile.ws.client;

/**
 * wsimport -p com.gemalto.latamsoft.vtr.chile.ws.client -keep http://localhost:8081/vtr_chile/services/VtrSucursalVirtualWS?wsdl
 * 
 * @author dciocca
 *
 */
public class MainTest {

	public static void main(String[] args) {

		VtrSucursalVirtualWSImplService helloService = new VtrSucursalVirtualWSImplService();
		VtrSucursalVirtualWS ws = helloService.getVtrSucursalVirtualWSImplPort();

		try {
			Terminal terminal = ws.getModelByMSISDN("123");
			System.out.println(terminal);
		} catch (VTRApiSOAPException_Exception e) {
			VTRApiSOAPException faultInfo = e.getFaultInfo();
			String faultCode = faultInfo.getFaultCode();
			System.out.println("faultCode: " + faultCode);
			System.out.println("faultMessage: " + e.getMessage());
		}
		
		try {
			Terminal terminal = ws.getModelByMSISDN("321");
			System.out.println(terminal);
		} catch (VTRApiSOAPException_Exception e) {
			VTRApiSOAPException faultInfo = e.getFaultInfo();
			String faultCode = faultInfo.getFaultCode();
			System.out.println("faultCode: " + faultCode);
			System.out.println("faultMessage: " + e.getMessage());
		}
		
		try {
			Terminal terminal = ws.getModelByMSISDN("111");
			System.out.println(terminal);
		} catch (VTRApiSOAPException_Exception e) {
			VTRApiSOAPException faultInfo = e.getFaultInfo();
			String faultCode = faultInfo.getFaultCode();
			System.out.println("faultCode: " + faultCode);
			System.out.println("faultMessage: " + e.getMessage());
		}
		
		try {
			ws.sendAllSettings("321");
		} catch (VTRApiSOAPException_Exception e) {
			VTRApiSOAPException faultInfo = e.getFaultInfo();
			String faultCode = faultInfo.getFaultCode();
			System.out.println("faultCode: " + faultCode);
			System.out.println("faultMessage: " + e.getMessage());
		}




	}

}
