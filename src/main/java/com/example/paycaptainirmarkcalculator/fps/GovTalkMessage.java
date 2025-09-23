package com.example.paycaptainirmarkcalculator.fps;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GovTalkMessage")
public class GovTalkMessage {
    @XmlElement
    public String EnvelopeVersion;
    @XmlElement
    public Header Header;
    @XmlElement
    public GovTalkDetails GovTalkDetails;
    @XmlElement
    public Body Body;
}
