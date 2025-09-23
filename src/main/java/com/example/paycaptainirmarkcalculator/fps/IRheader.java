package com.example.paycaptainirmarkcalculator.fps;

import jakarta.xml.bind.annotation.XmlElement;

public class IRheader {
    @XmlElement
    public com.example.paycaptainirmarkcalculator.fps.Keys Keys;
    @XmlElement
    public String PeriodEnd;
    @XmlElement
    public Principal Principal;
    @XmlElement
    public Agent Agent;
    @XmlElement
    public String DefaultCurrency;
    //@XmlElement
    //public Manifest Manifest;
    @XmlElement
    public IRmark IRmark;
    @XmlElement
    public String Sender;

}