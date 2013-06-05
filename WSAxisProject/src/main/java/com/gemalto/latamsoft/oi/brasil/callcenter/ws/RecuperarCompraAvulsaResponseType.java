/**
 * RecuperarCompraAvulsaResponseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gemalto.latamsoft.oi.brasil.callcenter.ws;

public class RecuperarCompraAvulsaResponseType  implements java.io.Serializable {
    private com.gemalto.latamsoft.oi.brasil.callcenter.ws.ResponseControlTypeCompraAvulsa responseControl;

    private com.gemalto.latamsoft.oi.brasil.callcenter.ws.RecuperarCompraAvulsaDataType[] recuperarCompraAvulsaData;

    public RecuperarCompraAvulsaResponseType() {
    }

    public RecuperarCompraAvulsaResponseType(
           com.gemalto.latamsoft.oi.brasil.callcenter.ws.ResponseControlTypeCompraAvulsa responseControl,
           com.gemalto.latamsoft.oi.brasil.callcenter.ws.RecuperarCompraAvulsaDataType[] recuperarCompraAvulsaData) {
           this.responseControl = responseControl;
           this.recuperarCompraAvulsaData = recuperarCompraAvulsaData;
    }


    /**
     * Gets the responseControl value for this RecuperarCompraAvulsaResponseType.
     * 
     * @return responseControl
     */
    public com.gemalto.latamsoft.oi.brasil.callcenter.ws.ResponseControlTypeCompraAvulsa getResponseControl() {
        return responseControl;
    }


    /**
     * Sets the responseControl value for this RecuperarCompraAvulsaResponseType.
     * 
     * @param responseControl
     */
    public void setResponseControl(com.gemalto.latamsoft.oi.brasil.callcenter.ws.ResponseControlTypeCompraAvulsa responseControl) {
        this.responseControl = responseControl;
    }


    /**
     * Gets the recuperarCompraAvulsaData value for this RecuperarCompraAvulsaResponseType.
     * 
     * @return recuperarCompraAvulsaData
     */
    public com.gemalto.latamsoft.oi.brasil.callcenter.ws.RecuperarCompraAvulsaDataType[] getRecuperarCompraAvulsaData() {
        return recuperarCompraAvulsaData;
    }


    /**
     * Sets the recuperarCompraAvulsaData value for this RecuperarCompraAvulsaResponseType.
     * 
     * @param recuperarCompraAvulsaData
     */
    public void setRecuperarCompraAvulsaData(com.gemalto.latamsoft.oi.brasil.callcenter.ws.RecuperarCompraAvulsaDataType[] recuperarCompraAvulsaData) {
        this.recuperarCompraAvulsaData = recuperarCompraAvulsaData;
    }

    public com.gemalto.latamsoft.oi.brasil.callcenter.ws.RecuperarCompraAvulsaDataType getRecuperarCompraAvulsaData(int i) {
        return this.recuperarCompraAvulsaData[i];
    }

    public void setRecuperarCompraAvulsaData(int i, com.gemalto.latamsoft.oi.brasil.callcenter.ws.RecuperarCompraAvulsaDataType _value) {
        this.recuperarCompraAvulsaData[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RecuperarCompraAvulsaResponseType)) return false;
        RecuperarCompraAvulsaResponseType other = (RecuperarCompraAvulsaResponseType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.responseControl==null && other.getResponseControl()==null) || 
             (this.responseControl!=null &&
              this.responseControl.equals(other.getResponseControl()))) &&
            ((this.recuperarCompraAvulsaData==null && other.getRecuperarCompraAvulsaData()==null) || 
             (this.recuperarCompraAvulsaData!=null &&
              java.util.Arrays.equals(this.recuperarCompraAvulsaData, other.getRecuperarCompraAvulsaData())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getResponseControl() != null) {
            _hashCode += getResponseControl().hashCode();
        }
        if (getRecuperarCompraAvulsaData() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRecuperarCompraAvulsaData());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRecuperarCompraAvulsaData(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RecuperarCompraAvulsaResponseType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.callcenter.brasil.oi.latamsoft.gemalto.com/", "RecuperarCompraAvulsaResponseType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseControl");
        elemField.setXmlName(new javax.xml.namespace.QName("", "responseControl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.callcenter.brasil.oi.latamsoft.gemalto.com/", "ResponseControlTypeCompraAvulsa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recuperarCompraAvulsaData");
        elemField.setXmlName(new javax.xml.namespace.QName("", "recuperarCompraAvulsaData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.callcenter.brasil.oi.latamsoft.gemalto.com/", "recuperarCompraAvulsaDataType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
