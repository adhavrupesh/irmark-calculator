package com.example.paycaptainirmarkcalculator.agent_auth;

import javax.xml.bind.annotation.XmlElement;

public class Header {
    @XmlElement
    public com.example.paycaptainirmarkcalculator.agent_auth.MessageDetails MessageDetails;
    @XmlElement
    public com.example.paycaptainirmarkcalculator.fps.SenderDetails SenderDetails;
}