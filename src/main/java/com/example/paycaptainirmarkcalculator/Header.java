package com.example.paycaptainirmarkcalculator;

import javax.xml.bind.annotation.XmlElement;

public class Header {
    @XmlElement
    public MessageDetails MessageDetails;
    @XmlElement
    public SenderDetails SenderDetails;
}