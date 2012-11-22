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
			ws.sendSetting("321", "gmail.com");
			
		} catch (VTRApiSOAPException e) {
			VTRApiSOAPFault faultInfo = e.getFaultInfo();
			System.out.println("faultCode: " + faultInfo.getFaultCode());
			System.out.println("faultMessage: " + faultInfo.getFaultMessage());
		}
		
		try {
			ws.sendSetting("1", "gmail.commmmmm");
			
		} catch (VTRApiSOAPException e) {
			VTRApiSOAPFault faultInfo = e.getFaultInfo();
			System.out.println("faultCode: " + faultInfo.getFaultCode());
			System.out.println("faultMessage: " + faultInfo.getFaultMessage());
		}




	}

}
