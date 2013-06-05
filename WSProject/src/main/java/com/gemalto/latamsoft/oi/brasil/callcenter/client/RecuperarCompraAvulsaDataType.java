
package com.gemalto.latamsoft.oi.brasil.callcenter.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RecuperarCompraAvulsaDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RecuperarCompraAvulsaDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idServico" type="{http://www.w3.org/2001/XMLSchema}int" form="qualified"/>
 *         &lt;element name="conteudo" type="{http://www.w3.org/2001/XMLSchema}string" form="qualified"/>
 *         &lt;element name="laTarifacao" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0" form="qualified"/>
 *         &lt;element name="laNavegacao" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0" form="qualified"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="dataCompra" type="{http://www.w3.org/2001/XMLSchema}long" form="qualified"/>
 *         &lt;element name="tipoConteudo" type="{http://www.w3.org/2001/XMLSchema}string" form="qualified"/>
 *         &lt;element name="urlReenvio" type="{http://www.w3.org/2001/XMLSchema}string" form="qualified"/>
 *         &lt;element name="valorTarifa" type="{http://www.w3.org/2001/XMLSchema}string" form="qualified"/>
 *         &lt;element name="canalVenda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="protocolo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="provedor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecuperarCompraAvulsaDataType", namespace = "http://alsb.telemar/soap/esb", propOrder = {
    "idServico",
    "conteudo",
    "laTarifacao",
    "laNavegacao",
    "status",
    "dataCompra",
    "tipoConteudo",
    "urlReenvio",
    "valorTarifa",
    "canalVenda",
    "protocolo",
    "provedor"
})
public class RecuperarCompraAvulsaDataType {

    protected int idServico;
    @XmlElement(required = true)
    protected String conteudo;
    protected Integer laTarifacao;
    protected Integer laNavegacao;
    protected String status;
    protected long dataCompra;
    @XmlElement(required = true)
    protected String tipoConteudo;
    @XmlElement(required = true)
    protected String urlReenvio;
    @XmlElement(required = true)
    protected String valorTarifa;
    protected String canalVenda;
    protected String protocolo;
    protected String provedor;

    /**
     * Gets the value of the idServico property.
     * 
     */
    public int getIdServico() {
        return idServico;
    }

    /**
     * Sets the value of the idServico property.
     * 
     */
    public void setIdServico(int value) {
        this.idServico = value;
    }

    /**
     * Gets the value of the conteudo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConteudo() {
        return conteudo;
    }

    /**
     * Sets the value of the conteudo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConteudo(String value) {
        this.conteudo = value;
    }

    /**
     * Gets the value of the laTarifacao property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLaTarifacao() {
        return laTarifacao;
    }

    /**
     * Sets the value of the laTarifacao property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLaTarifacao(Integer value) {
        this.laTarifacao = value;
    }

    /**
     * Gets the value of the laNavegacao property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLaNavegacao() {
        return laNavegacao;
    }

    /**
     * Sets the value of the laNavegacao property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLaNavegacao(Integer value) {
        this.laNavegacao = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the dataCompra property.
     * 
     */
    public long getDataCompra() {
        return dataCompra;
    }

    /**
     * Sets the value of the dataCompra property.
     * 
     */
    public void setDataCompra(long value) {
        this.dataCompra = value;
    }

    /**
     * Gets the value of the tipoConteudo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoConteudo() {
        return tipoConteudo;
    }

    /**
     * Sets the value of the tipoConteudo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoConteudo(String value) {
        this.tipoConteudo = value;
    }

    /**
     * Gets the value of the urlReenvio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlReenvio() {
        return urlReenvio;
    }

    /**
     * Sets the value of the urlReenvio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlReenvio(String value) {
        this.urlReenvio = value;
    }

    /**
     * Gets the value of the valorTarifa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValorTarifa() {
        return valorTarifa;
    }

    /**
     * Sets the value of the valorTarifa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValorTarifa(String value) {
        this.valorTarifa = value;
    }

    /**
     * Gets the value of the canalVenda property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCanalVenda() {
        return canalVenda;
    }

    /**
     * Sets the value of the canalVenda property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCanalVenda(String value) {
        this.canalVenda = value;
    }

    /**
     * Gets the value of the protocolo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProtocolo() {
        return protocolo;
    }

    /**
     * Sets the value of the protocolo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProtocolo(String value) {
        this.protocolo = value;
    }

    /**
     * Gets the value of the provedor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvedor() {
        return provedor;
    }

    /**
     * Sets the value of the provedor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvedor(String value) {
        this.provedor = value;
    }

}
