package com.example.paycaptainirmarkcalculator;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class TaxCode {
    @XmlAttribute(name = "BasisNonCumulative")
    public String BasisNonCumulative;
    @XmlAttribute(name = "TaxRegime")
    public String TaxRegime;
    @XmlValue
    public String text;
}