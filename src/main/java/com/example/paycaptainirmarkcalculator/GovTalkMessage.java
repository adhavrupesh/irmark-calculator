package com.example.paycaptainirmarkcalculator;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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
