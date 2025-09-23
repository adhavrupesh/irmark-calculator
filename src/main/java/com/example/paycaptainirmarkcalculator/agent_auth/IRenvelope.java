package com.example.paycaptainirmarkcalculator.agent_auth;

import jakarta.xml.bind.annotation.XmlElement;


public class IRenvelope {
    @XmlElement
    public IRheader IRheader;
    @XmlElement
    public AgentRequest AgentRequest;
}