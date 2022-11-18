
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSContext complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSContext">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dbType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dcName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sessionId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="slnName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSContext", propOrder = {
    "dbType",
    "dcName",
    "password",
    "sessionId",
    "slnName",
    "userName"
})
public class WSContext {

    protected int dbType;
    @XmlElement(required = true, nillable = true)
    protected String dcName;
    @XmlElement(required = true, nillable = true)
    protected String password;
    @XmlElement(required = true, nillable = true)
    protected String sessionId;
    @XmlElement(required = true, nillable = true)
    protected String slnName;
    @XmlElement(required = true, nillable = true)
    protected String userName;

    /**
     * Gets the value of the dbType property.
     * 
     */
    public int getDbType() {
        return dbType;
    }

    /**
     * Sets the value of the dbType property.
     * 
     */
    public void setDbType(int value) {
        this.dbType = value;
    }

    /**
     * Gets the value of the dcName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcName() {
        return dcName;
    }

    /**
     * Sets the value of the dcName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcName(String value) {
        this.dcName = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the sessionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * Sets the value of the sessionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionId(String value) {
        this.sessionId = value;
    }

    /**
     * Gets the value of the slnName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSlnName() {
        return slnName;
    }

    /**
     * Sets the value of the slnName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSlnName(String value) {
        this.slnName = value;
    }

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

}
