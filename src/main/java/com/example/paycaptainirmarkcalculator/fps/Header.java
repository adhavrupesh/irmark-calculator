package com.example.paycaptainirmarkcalculator.fps;

import jakarta.xml.bind.annotation.XmlElement;

public class Header {
    @XmlElement
    public com.example.paycaptainirmarkcalculator.fps.MessageDetails MessageDetails;
    @XmlElement
    public com.example.paycaptainirmarkcalculator.fps.SenderDetails SenderDetails;
}