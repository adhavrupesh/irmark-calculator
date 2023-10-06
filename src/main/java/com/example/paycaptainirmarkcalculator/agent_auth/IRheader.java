package com.example.paycaptainirmarkcalculator.agent_auth;
import javax.xml.bind.annotation.XmlElement;

public class IRheader {
    @XmlElement
    public com.example.paycaptainirmarkcalculator.fps.Keys Keys;
    @XmlElement
    public String PeriodEnd;
    @XmlElement
    public String DefaultCurrency;
    @XmlElement
    public String Sender;
    @XmlElement
    public IRmark IRmark;
 }