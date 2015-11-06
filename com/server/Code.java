
package com.server;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for code.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="code">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CREATE"/>
 *     &lt;enumeration value="READ"/>
 *     &lt;enumeration value="UPDATE"/>
 *     &lt;enumeration value="DELETE"/>
 *     &lt;enumeration value="DISPLAY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "code")
@XmlEnum
public enum Code {

    CREATE,
    READ,
    UPDATE,
    DELETE,
    DISPLAY;

    public String value() {
        return name();
    }

    public static Code fromValue(String v) {
        return valueOf(v);
    }

}
