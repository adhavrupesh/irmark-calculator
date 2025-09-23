package com.example.paycaptainirmarkcalculator.fps;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;

public class TaxCode {
    @XmlAttribute(name = "BasisNonCumulative")
    public String BasisNonCumulative;
    @XmlAttribute(name = "TaxRegime")
    public String TaxRegime;
    @XmlValue
    public String text;
}