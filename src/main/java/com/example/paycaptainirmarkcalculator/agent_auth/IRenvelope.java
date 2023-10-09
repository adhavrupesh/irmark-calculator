package com.example.paycaptainirmarkcalculator.agent_auth;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlType(namespace="http://www.govtalk.gov.uk/taxation/AgentAuthRequest/1")
public class IRenvelope {

    @XmlAttribute(name = "xmlns", namespace = "http://www.govtalk.gov.uk/taxation/AgentAuthRequest/1")
    public String xmlns;

    @XmlElement
    public IRheader IRheader;
    @XmlElement
    public AgentRequest AgentRequest;
}