
package com.gemalto.latamsoft.oi.brasil.callcenter.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for recuperarCompraAvulsaDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="recuperarCompraAvulsaDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idServico" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nomeServico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="laTarifacao" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="laNavegacao" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="statusServico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataAtivacao" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="dataCancelamento" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="tipoConteudo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="urlReenvio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="urlCancelamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="valorTarifa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="canalVenda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="protocolo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="provedor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "recuperarCompraAvulsaDataType", propOrder = {
    "idServico",
    "nomeServico",
    "laTarifacao",
    "laNavegacao",
    "statusServico",
    "dataAtivacao",
    "dataCancelamento",
    "tipoConteudo",
    "urlReenvio",
    "urlCancelamento",
    "valorTarifa",
    "canalVenda",
    "protocolo",
    "provedor"
})
public class RecuperarCompraAvulsaDataType {

    protected int idServico;
    protected String nomeServico;
    protected int laTarifacao;
    protected int laNavegacao;
    protected String statusServico;
    protected long dataAtivacao;
    protected long dataCancelamento;
    protected String tipoConteudo;
    protected String urlReenvio;
    protected String urlCancelamento;
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
     * Gets the value of the nomeServico property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeServico() {
        return nomeServico;
    }

    /**
     * Sets the value of the nomeServico property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeServico(String value) {
        this.nomeServico = value;
    }

    /**
     * Gets the value of the laTarifacao property.
     * 
     */
    public int getLaTarifacao() {
        return laTarifacao;
    }

    /**
     * Sets the value of the laTarifacao property.
     * 
     */
    public void setLaTarifacao(int value) {
        this.laTarifacao = value;
    }

    /**
     * Gets the value of the laNavegacao property.
     * 
     */
    public int getLaNavegacao() {
        return laNavegacao;
    }

    /**
     * Sets the value of the laNavegacao property.
     * 
     */
    public void setLaNavegacao(int value) {
        this.laNavegacao = value;
    }

    /**
     * Gets the value of the statusServico property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusServico() {
        return statusServico;
    }

    /**
     * Sets the value of the statusServico property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusServico(String value) {
        this.statusServico = value;
    }

    /**
     * Gets the value of the dataAtivacao property.
     * 
     */
    public long getDataAtivacao() {
        return dataAtivacao;
    }

    /**
     * Sets the value of the dataAtivacao property.
     * 
     */
    public void setDataAtivacao(long value) {
        this.dataAtivacao = value;
    }

    /**
     * Gets the value of the dataCancelamento property.
     * 
     */
    public long getDataCancelamento() {
        return dataCancelamento;
    }

    /**
     * Sets the value of the dataCancelamento property.
     * 
     */
    public void setDataCancelamento(long value) {
        this.dataCancelamento = value;
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
     * Gets the value of the urlCancelamento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlCancelamento() {
        return urlCancelamento;
    }

    /**
     * Sets the value of the urlCancelamento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlCancelamento(String value) {
        this.urlCancelamento = value;
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
