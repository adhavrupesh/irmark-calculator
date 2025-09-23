package com.example.paycaptainirmarkcalculator.eps;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GovTalkMessage")
public class GovTalkMessage {
    @XmlElement
    public String EnvelopeVersion;
    @XmlElement
    public com.example.paycaptainirmarkcalculator.fps.Header Header;
    @XmlElement
    public com.example.paycaptainirmarkcalculator.fps.GovTalkDetails GovTalkDetails;
    @XmlElement
    public com.example.paycaptainirmarkcalculator.eps.Body Body;
}
