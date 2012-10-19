
package spring.ejemplos.diecisiete.ws.cxf.client.jaxwsgeneratedcode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for buscarPersona complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="buscarPersona">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="legajo" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buscarPersona", propOrder = {
    "legajo"
})
public class BuscarPersona {

    protected long legajo;

    /**
     * Gets the value of the legajo property.
     * 
     */
    public long getLegajo() {
        return legajo;
    }

    /**
     * Sets the value of the legajo property.
     * 
     */
    public void setLegajo(long value) {
        this.legajo = value;
    }

}
