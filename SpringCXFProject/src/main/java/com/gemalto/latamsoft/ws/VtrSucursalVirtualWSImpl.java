package com.gemalto.latamsoft.ws;

import javax.jws.WebService;


@WebService(endpointInterface = "com.gemalto.latamsoft.ws.VtrSucursalVirtualWS")
public class VtrSucursalVirtualWSImpl implements VtrSucursalVirtualWS{

	@Override
	public Setting getModelbyMSISDN(String msisdn) {
		// TODO Auto-generated method stub
		System.out.println("getModelbyMSISDN..");
		return null;
	}

	@Override
	public void sendSetting(String msisdn, String serviceName) {
		// TODO Auto-generated method stub
		System.out.println("sendSetting..");
	}

	@Override
	public void sendAllSettings(String msisdn) {
		// TODO Auto-generated method stub
		System.out.println("sendAllSettings..");
	}


}
