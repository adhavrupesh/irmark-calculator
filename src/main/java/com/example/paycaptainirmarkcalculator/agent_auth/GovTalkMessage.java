package com.example.paycaptainirmarkcalculator.agent_auth;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GovTalkMessage")
public class GovTalkMessage {
    @XmlElement
    public String EnvelopeVersion;
    @XmlElement
    public com.example.paycaptainirmarkcalculator.agent_auth.Header Header;
    @XmlElement
    public com.example.paycaptainirmarkcalculator.fps.GovTalkDetails GovTalkDetails;
    @XmlElement
    public com.example.paycaptainirmarkcalculator.AgentAuth.Body Body;
}
