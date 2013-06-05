
package com.gemalto.latamsoft.oi.brasil.callcenter.cxf.client2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResponseControlTypeCompraAvulsa complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseControlTypeCompraAvulsa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" form="qualified"/>
 *         &lt;element name="reason" type="{http://www.w3.org/2001/XMLSchema}string" form="qualified"/>
 *         &lt;element name="detail" type="{http://www.w3.org/2001/XMLSchema}string" form="qualified"/>
 *         &lt;element name="transacao" type="{http://www.w3.org/2001/XMLSchema}string" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseControlTypeCompraAvulsa", namespace = "http://alsb.telemar/soap/esb", propOrder = {
    "code",
    "reason",
    "detail",
    "transacao"
})
public class ResponseControlTypeCompraAvulsa {

    @XmlElement(required = true)
    protected String code;
    @XmlElement(required = true)
    protected String reason;
    @XmlElement(required = true)
    protected String detail;
    @XmlElement(required = true)
    protected String transacao;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the reason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReason() {
        return reason;
    }

    /**
     * Sets the value of the reason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReason(String value) {
        this.reason = value;
    }

    /**
     * Gets the value of the detail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetail() {
        return detail;
    }

    /**
     * Sets the value of the detail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetail(String value) {
        this.detail = value;
    }

    /**
     * Gets the value of the transacao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransacao() {
        return transacao;
    }

    /**
     * Sets the value of the transacao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransacao(String value) {
        this.transacao = value;
    }

}
