package com.example.paycaptainirmarkcalculator.agent_auth;

import jakarta.xml.bind.annotation.XmlElement;

public class PAYE {
    @XmlElement
    public TaxOffice TaxOffice;
    @XmlElement
    public String AOreference;
    @XmlElement
    public String YourReference;
    @XmlElement
    public String AuthRequestID;
}