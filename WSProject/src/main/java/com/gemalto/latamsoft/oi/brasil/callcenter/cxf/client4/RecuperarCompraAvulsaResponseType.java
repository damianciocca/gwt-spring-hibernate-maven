
package com.gemalto.latamsoft.oi.brasil.callcenter.cxf.client4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RecuperarCompraAvulsaResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RecuperarCompraAvulsaResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="responseControl" type="{http://alsb.telemar/soap/esb}ResponseControlTypeCompraAvulsa"/>
 *         &lt;element name="RecuperarCompraAvulsaData" type="{http://alsb.telemar/soap/esb}RecuperarCompraAvulsaDataType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecuperarCompraAvulsaResponseType", namespace = "http://alsb.telemar/xsd/RecuperarCompraAvulsaResponse", propOrder = {
    "responseControl",
    "recuperarCompraAvulsaData"
})
public class RecuperarCompraAvulsaResponseType {

    @XmlElement(required = true)
    protected ResponseControlTypeCompraAvulsa responseControl;
    @XmlElement(name = "RecuperarCompraAvulsaData")
    protected List<RecuperarCompraAvulsaDataType> recuperarCompraAvulsaData;

    /**
     * Gets the value of the responseControl property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseControlTypeCompraAvulsa }
     *     
     */
    public ResponseControlTypeCompraAvulsa getResponseControl() {
        return responseControl;
    }

    /**
     * Sets the value of the responseControl property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseControlTypeCompraAvulsa }
     *     
     */
    public void setResponseControl(ResponseControlTypeCompraAvulsa value) {
        this.responseControl = value;
    }

    /**
     * Gets the value of the recuperarCompraAvulsaData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recuperarCompraAvulsaData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecuperarCompraAvulsaData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RecuperarCompraAvulsaDataType }
     * 
     * 
     */
    public List<RecuperarCompraAvulsaDataType> getRecuperarCompraAvulsaData() {
        if (recuperarCompraAvulsaData == null) {
            recuperarCompraAvulsaData = new ArrayList<RecuperarCompraAvulsaDataType>();
        }
        return this.recuperarCompraAvulsaData;
    }

}
