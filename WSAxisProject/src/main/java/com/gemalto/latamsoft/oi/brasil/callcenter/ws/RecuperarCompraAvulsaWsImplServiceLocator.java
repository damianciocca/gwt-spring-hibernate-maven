/**
 * RecuperarCompraAvulsaWsImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gemalto.latamsoft.oi.brasil.callcenter.ws;

public class RecuperarCompraAvulsaWsImplServiceLocator extends org.apache.axis.client.Service implements com.gemalto.latamsoft.oi.brasil.callcenter.ws.RecuperarCompraAvulsaWsImplService {

    public RecuperarCompraAvulsaWsImplServiceLocator() {
    }


    public RecuperarCompraAvulsaWsImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public RecuperarCompraAvulsaWsImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for RecuperarCompraAvulsaWsImplPort
    private java.lang.String RecuperarCompraAvulsaWsImplPort_address = "http://localhost:8081/oi-brasil-callcenter-soap-ws/services/RecuperarCompraAvulsaWs";

    public java.lang.String getRecuperarCompraAvulsaWsImplPortAddress() {
        return RecuperarCompraAvulsaWsImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String RecuperarCompraAvulsaWsImplPortWSDDServiceName = "RecuperarCompraAvulsaWsImplPort";

    public java.lang.String getRecuperarCompraAvulsaWsImplPortWSDDServiceName() {
        return RecuperarCompraAvulsaWsImplPortWSDDServiceName;
    }

    public void setRecuperarCompraAvulsaWsImplPortWSDDServiceName(java.lang.String name) {
        RecuperarCompraAvulsaWsImplPortWSDDServiceName = name;
    }

    public com.gemalto.latamsoft.oi.brasil.callcenter.ws.RecuperarCompraAvulsaWs getRecuperarCompraAvulsaWsImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(RecuperarCompraAvulsaWsImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getRecuperarCompraAvulsaWsImplPort(endpoint);
    }

    public com.gemalto.latamsoft.oi.brasil.callcenter.ws.RecuperarCompraAvulsaWs getRecuperarCompraAvulsaWsImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.gemalto.latamsoft.oi.brasil.callcenter.ws.RecuperarCompraAvulsaWsImplServiceSoapBindingStub _stub = new com.gemalto.latamsoft.oi.brasil.callcenter.ws.RecuperarCompraAvulsaWsImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getRecuperarCompraAvulsaWsImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setRecuperarCompraAvulsaWsImplPortEndpointAddress(java.lang.String address) {
        RecuperarCompraAvulsaWsImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.gemalto.latamsoft.oi.brasil.callcenter.ws.RecuperarCompraAvulsaWs.class.isAssignableFrom(serviceEndpointInterface)) {
                com.gemalto.latamsoft.oi.brasil.callcenter.ws.RecuperarCompraAvulsaWsImplServiceSoapBindingStub _stub = new com.gemalto.latamsoft.oi.brasil.callcenter.ws.RecuperarCompraAvulsaWsImplServiceSoapBindingStub(new java.net.URL(RecuperarCompraAvulsaWsImplPort_address), this);
                _stub.setPortName(getRecuperarCompraAvulsaWsImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("RecuperarCompraAvulsaWsImplPort".equals(inputPortName)) {
            return getRecuperarCompraAvulsaWsImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.callcenter.brasil.oi.latamsoft.gemalto.com/", "RecuperarCompraAvulsaWsImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.callcenter.brasil.oi.latamsoft.gemalto.com/", "RecuperarCompraAvulsaWsImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("RecuperarCompraAvulsaWsImplPort".equals(portName)) {
            setRecuperarCompraAvulsaWsImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
