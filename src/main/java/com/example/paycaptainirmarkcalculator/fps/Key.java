package com.example.paycaptainirmarkcalculator.fps;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;

public class Key {

    @XmlAttribute(name = "Type")
    public String Type;
    @XmlValue
    public String text;

}