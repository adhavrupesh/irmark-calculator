package com.example.paycaptainirmarkcalculator.agent_auth;

import jakarta.xml.bind.annotation.XmlElement;

public class Header {
    @XmlElement
    public MessageDetails MessageDetails;
    @XmlElement
    public com.example.paycaptainirmarkcalculator.fps.SenderDetails SenderDetails;
}