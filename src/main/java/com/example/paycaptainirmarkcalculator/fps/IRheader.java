package com.example.paycaptainirmarkcalculator.fps;

import javax.xml.bind.annotation.XmlElement;

public class IRheader {
    @XmlElement
    public com.example.paycaptainirmarkcalculator.fps.Keys Keys;
    @XmlElement
    public String PeriodEnd;
    @XmlElement
    public String DefaultCurrency;
    @XmlElement
    public IRmark IRmark;
    @XmlElement
    public String Sender;

}