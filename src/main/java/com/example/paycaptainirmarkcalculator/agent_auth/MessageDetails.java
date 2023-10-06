package com.example.paycaptainirmarkcalculator.agent_auth;

import javax.xml.bind.annotation.XmlElement;

public class MessageDetails {
    @XmlElement
    public String MessageDetailsClass;
    @XmlElement
    public String Qualifier;
    @XmlElement
    public String Function;
    @XmlElement
    public String CorrelationID;
    @XmlElement
    public String Transformation;
    @XmlElement
    public String GatewayTest;
    @XmlElement
    public String GatewayTimestamp;
}