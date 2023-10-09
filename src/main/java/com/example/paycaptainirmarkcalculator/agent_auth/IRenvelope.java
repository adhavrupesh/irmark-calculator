package com.example.paycaptainirmarkcalculator.agent_auth;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAttribute;

public class IRenvelope {

    @XmlAttribute(name = "xmlns", namespace = "http://www.govtalk.gov.uk/taxation/AgentAuthRequest/1")
    public String xmlns;

    @XmlElement
    public com.example.paycaptainirmarkcalculator.agent_auth.IRheader IRheader;
    @XmlElement
    public com.example.paycaptainirmarkcalculator.agent_auth.AgentRequest AgentRequest;
}