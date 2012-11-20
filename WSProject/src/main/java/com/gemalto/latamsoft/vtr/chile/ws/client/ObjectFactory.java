
package com.gemalto.latamsoft.vtr.chile.ws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.gemalto.latamsoft.vtr.chile.ws.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetModelByMSISDNResponse_QNAME = new QName("http://ws.chile.vtr.latamsoft.gemalto.com/", "getModelByMSISDNResponse");
    private final static QName _SendAllSettingsResponse_QNAME = new QName("http://ws.chile.vtr.latamsoft.gemalto.com/", "sendAllSettingsResponse");
    private final static QName _GetModelByMSISDN_QNAME = new QName("http://ws.chile.vtr.latamsoft.gemalto.com/", "getModelByMSISDN");
    private final static QName _VTRApiSOAPException_QNAME = new QName("http://ws.chile.vtr.latamsoft.gemalto.com/", "VTRApiSOAPException");
    private final static QName _SendSettingResponse_QNAME = new QName("http://ws.chile.vtr.latamsoft.gemalto.com/", "sendSettingResponse");
    private final static QName _SendAllSettings_QNAME = new QName("http://ws.chile.vtr.latamsoft.gemalto.com/", "sendAllSettings");
    private final static QName _SendSetting_QNAME = new QName("http://ws.chile.vtr.latamsoft.gemalto.com/", "sendSetting");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.gemalto.latamsoft.vtr.chile.ws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SendAllSettings }
     * 
     */
    public SendAllSettings createSendAllSettings() {
        return new SendAllSettings();
    }

    /**
     * Create an instance of {@link Terminal }
     * 
     */
    public Terminal createTerminal() {
        return new Terminal();
    }

    /**
     * Create an instance of {@link GetModelByMSISDN }
     * 
     */
    public GetModelByMSISDN createGetModelByMSISDN() {
        return new GetModelByMSISDN();
    }

    /**
     * Create an instance of {@link SendAllSettingsResponse }
     * 
     */
    public SendAllSettingsResponse createSendAllSettingsResponse() {
        return new SendAllSettingsResponse();
    }

    /**
     * Create an instance of {@link SendSettingResponse }
     * 
     */
    public SendSettingResponse createSendSettingResponse() {
        return new SendSettingResponse();
    }

    /**
     * Create an instance of {@link SendSetting }
     * 
     */
    public SendSetting createSendSetting() {
        return new SendSetting();
    }

    /**
     * Create an instance of {@link VTRApiSOAPException }
     * 
     */
    public VTRApiSOAPException createVTRApiSOAPException() {
        return new VTRApiSOAPException();
    }

    /**
     * Create an instance of {@link GetModelByMSISDNResponse }
     * 
     */
    public GetModelByMSISDNResponse createGetModelByMSISDNResponse() {
        return new GetModelByMSISDNResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetModelByMSISDNResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.chile.vtr.latamsoft.gemalto.com/", name = "getModelByMSISDNResponse")
    public JAXBElement<GetModelByMSISDNResponse> createGetModelByMSISDNResponse(GetModelByMSISDNResponse value) {
        return new JAXBElement<GetModelByMSISDNResponse>(_GetModelByMSISDNResponse_QNAME, GetModelByMSISDNResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendAllSettingsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.chile.vtr.latamsoft.gemalto.com/", name = "sendAllSettingsResponse")
    public JAXBElement<SendAllSettingsResponse> createSendAllSettingsResponse(SendAllSettingsResponse value) {
        return new JAXBElement<SendAllSettingsResponse>(_SendAllSettingsResponse_QNAME, SendAllSettingsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetModelByMSISDN }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.chile.vtr.latamsoft.gemalto.com/", name = "getModelByMSISDN")
    public JAXBElement<GetModelByMSISDN> createGetModelByMSISDN(GetModelByMSISDN value) {
        return new JAXBElement<GetModelByMSISDN>(_GetModelByMSISDN_QNAME, GetModelByMSISDN.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VTRApiSOAPException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.chile.vtr.latamsoft.gemalto.com/", name = "VTRApiSOAPException")
    public JAXBElement<VTRApiSOAPException> createVTRApiSOAPException(VTRApiSOAPException value) {
        return new JAXBElement<VTRApiSOAPException>(_VTRApiSOAPException_QNAME, VTRApiSOAPException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendSettingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.chile.vtr.latamsoft.gemalto.com/", name = "sendSettingResponse")
    public JAXBElement<SendSettingResponse> createSendSettingResponse(SendSettingResponse value) {
        return new JAXBElement<SendSettingResponse>(_SendSettingResponse_QNAME, SendSettingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendAllSettings }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.chile.vtr.latamsoft.gemalto.com/", name = "sendAllSettings")
    public JAXBElement<SendAllSettings> createSendAllSettings(SendAllSettings value) {
        return new JAXBElement<SendAllSettings>(_SendAllSettings_QNAME, SendAllSettings.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendSetting }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.chile.vtr.latamsoft.gemalto.com/", name = "sendSetting")
    public JAXBElement<SendSetting> createSendSetting(SendSetting value) {
        return new JAXBElement<SendSetting>(_SendSetting_QNAME, SendSetting.class, null, value);
    }

}
