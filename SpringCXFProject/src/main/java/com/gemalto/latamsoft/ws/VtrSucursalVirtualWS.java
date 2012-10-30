package com.gemalto.latamsoft.ws;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * This WS provide a set of Web sevice API that will allow to manage the 
 * request for handset model information and setting sets delivery
 * 
 * @author dciocca
 */
@WebService
public interface VtrSucursalVirtualWS{

	/**
	 * A method that given a MSISDN, return the model associated and supported services. 
	 * (the answer will be Brand,  Model and Services). 
	 * 
	 * @param msisdn
	 * @return
	 */
	@WebResult(name="setting")
	Setting getModelbyMSISDN(@WebParam(name="msisdn") String msisdn);
	
	/**
	 * A method to send the configuration of a particular service.
	 * This method sends to MSISDN the Setting set service with the specified name.
	 * 
	 * @param msisdn
	 * @return
	 */
	void sendSetting(@WebParam(name="msisdn") String msisdn, 
					 @WebParam(name="serviceName") String serviceName);
	
	/**
	 * A  Method to send all the services supported by the handset and configured 
	 * in the DM business rules, to destination MSISDN.
	 * 
	 * @param msisdn
	 */
	void sendAllSettings(@WebParam(name="msisdn") String msisdn);
}
