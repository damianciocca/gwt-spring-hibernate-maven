
package com.gemalto.latamsoft.oi.brasil.callcenter.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://alsb.telemar/xsd/RecuperarCompraAvulsaResponse}RecuperarCompraAvulsaResponse"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "recuperarCompraAvulsaResponse"
})
@XmlRootElement(name = "RecuperarCompraAvulsaResponse")
public class RecuperarCompraAvulsaResponse {

    @XmlElement(name = "RecuperarCompraAvulsaResponse", namespace = "http://alsb.telemar/xsd/RecuperarCompraAvulsaResponse", required = true)
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
