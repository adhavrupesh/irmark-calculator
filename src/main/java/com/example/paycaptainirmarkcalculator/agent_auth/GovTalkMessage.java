package com.example.paycaptainirmarkcalculator.agent_auth;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GovTalkMessage")
public class GovTalkMessage {
    @XmlElement
    public String EnvelopeVersion;
    @XmlElement
    public Header Header;
    @XmlElement
    public com.example.paycaptainirmarkcalculator.fps.GovTalkDetails GovTalkDetails;
    @XmlElement
    public Body Body;
}
