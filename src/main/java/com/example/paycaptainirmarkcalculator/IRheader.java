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
    public IRmark IRmark;
    @XmlElement
    public String Sender;

}