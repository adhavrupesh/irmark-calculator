package com.example.paycaptainirmarkcalculator.agent_auth;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(namespace="http://www.govtalk.gov.uk/taxation/AgentAuthRequest/1")
public class IRenvelope {
    @XmlElement
    public com.example.paycaptainirmarkcalculator.agent_auth.IRheader IRheader;
    @XmlElement
    public com.example.paycaptainirmarkcalculator.agent_auth.AgentRequest AgentRequest;
}