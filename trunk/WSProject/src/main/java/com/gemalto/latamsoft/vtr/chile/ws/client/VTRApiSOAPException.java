
package com.gemalto.latamsoft.vtr.chile.ws.client;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "VTRApiSOAPFault", targetNamespace = "http://ws.chile.vtr.latamsoft.gemalto.com/")
public class VTRApiSOAPException
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private VTRApiSOAPFault faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public VTRApiSOAPException(String message, VTRApiSOAPFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public VTRApiSOAPException(String message, VTRApiSOAPFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.gemalto.latamsoft.vtr.chile.ws.client.VTRApiSOAPFault
     */
    public VTRApiSOAPFault getFaultInfo() {
        return faultInfo;
    }

}