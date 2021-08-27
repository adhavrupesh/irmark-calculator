package com.example.paycaptainirmarkcalculator;

import javax.xml.bind.annotation.XmlElement;

public class GovTalkDetails {
    @XmlElement
    public Keys Keys;
    @XmlElement
    public TargetDetails TargetDetails;
    @XmlElement
    ChannelRouting ChannelRouting;

}