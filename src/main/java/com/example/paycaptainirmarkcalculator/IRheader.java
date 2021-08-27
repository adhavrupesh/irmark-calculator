package com.example.paycaptainirmarkcalculator;

import javax.xml.bind.annotation.XmlElement;

public class IRheader {
    @XmlElement
    public Keys Keys;
    @XmlElement
    public String PeriodEnd;
    @XmlElement
    public String DefaultCurrency;
    @XmlElement
    IRmark IRmark;
    @XmlElement
    public String Sender;

}