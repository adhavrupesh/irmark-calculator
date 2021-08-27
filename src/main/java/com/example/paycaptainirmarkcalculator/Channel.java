package com.example.paycaptainirmarkcalculator;

import javax.xml.bind.annotation.XmlElement;

public class Channel {
    @XmlElement
    public String URI;
    @XmlElement
    public String Product;
    @XmlElement
    public String Version;

}