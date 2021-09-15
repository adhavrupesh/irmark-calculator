package com.example.paycaptainirmarkcalculator.fps;

import javax.xml.bind.annotation.XmlElement;

public class Header {
    @XmlElement
    public com.example.paycaptainirmarkcalculator.fps.MessageDetails MessageDetails;
    @XmlElement
    public com.example.paycaptainirmarkcalculator.fps.SenderDetails SenderDetails;
}