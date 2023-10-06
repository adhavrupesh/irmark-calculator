package com.example.paycaptainirmarkcalculator.agent_auth;

import javax.xml.bind.annotation.XmlElement;

public class PAYE {
    @XmlElement
    public com.example.paycaptainirmarkcalculator.agent_auth.TaxOffice TaxOffice;
    @XmlElement
    public String AOreference;
    @XmlElement
    public String YourReference;
    @XmlElement
    public String AuthRequestID;
}