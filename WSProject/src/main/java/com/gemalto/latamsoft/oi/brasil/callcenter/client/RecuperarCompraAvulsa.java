
package com.gemalto.latamsoft.oi.brasil.callcenter.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RecuperarCompraAvulsa complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RecuperarCompraAvulsa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RecuperarCompraAvulsaRequest" type="{http://ws.callcenter.brasil.oi.latamsoft.gemalto.com/}recuperarCompraAvulsaRequestType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecuperarCompraAvulsa", propOrder = {
    "recuperarCompraAvulsaRequest"
})
public class RecuperarCompraAvulsa {

    @XmlElement(name = "RecuperarCompraAvulsaRequest")
    protected RecuperarCompraAvulsaRequestType recuperarCompraAvulsaRequest;

    /**
     * Gets the value of the recuperarCompraAvulsaRequest property.
     * 
     * @return
     *     possible object is
     *     {@link RecuperarCompraAvulsaRequestType }
     *     
     */
    public RecuperarCompraAvulsaRequestType getRecuperarCompraAvulsaRequest() {
        return recuperarCompraAvulsaRequest;
    }

    /**
     * Sets the value of the recuperarCompraAvulsaRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecuperarCompraAvulsaRequestType }
     *     
     */
    public void setRecuperarCompraAvulsaRequest(RecuperarCompraAvulsaRequestType value) {
        this.recuperarCompraAvulsaRequest = value;
    }

}
