
package com.gemalto.latamsoft.oi.brasil.callcenter.cxf.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RecuperarCompraAvulsaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RecuperarCompraAvulsaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RecuperarCompraAvulsaResponse" type="{http://ws.callcenter.brasil.oi.latamsoft.gemalto.com/}RecuperarCompraAvulsaResponseType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecuperarCompraAvulsaResponse", propOrder = {
    "recuperarCompraAvulsaResponse"
})
public class RecuperarCompraAvulsaResponse {

    @XmlElement(name = "RecuperarCompraAvulsaResponse")
    protected RecuperarCompraAvulsaResponseType recuperarCompraAvulsaResponse;

    /**
     * Gets the value of the recuperarCompraAvulsaResponse property.
     * 
     * @return
     *     possible object is
     *     {@link RecuperarCompraAvulsaResponseType }
     *     
     */
    public RecuperarCompraAvulsaResponseType getRecuperarCompraAvulsaResponse() {
        return recuperarCompraAvulsaResponse;
    }

    /**
     * Sets the value of the recuperarCompraAvulsaResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecuperarCompraAvulsaResponseType }
     *     
     */
    public void setRecuperarCompraAvulsaResponse(RecuperarCompraAvulsaResponseType value) {
        this.recuperarCompraAvulsaResponse = value;
    }

}
