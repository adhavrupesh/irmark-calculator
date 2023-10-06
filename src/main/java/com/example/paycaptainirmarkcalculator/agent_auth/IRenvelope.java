package com.example.paycaptainirmarkcalculator.agent_auth;

import javax.xml.bind.annotation.XmlElement;

public class IRenvelope {
    @XmlElement
    public com.example.paycaptainirmarkcalculator.agent_auth.IRheader IRheader;
    @XmlElement
    public com.example.paycaptainirmarkcalculator.agent_auth.AgentRequest AgentRequest;
}