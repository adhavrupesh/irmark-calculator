package com.example.paycaptainirmarkcalculator;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class IRmark {
    @XmlAttribute(name = "Type")
    public String Type;
    @XmlValue
    public String text;


}