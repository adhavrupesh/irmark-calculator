package com.example.paycaptainirmarkcalculator.fps;

import jakarta.xml.bind.annotation.XmlElement;
import java.util.List;

public class Address {
    @XmlElement
    public List<String> Line;
    @XmlElement
    public String UKPostcode;
    @XmlElement
    public String PostCode;
    @XmlElement
    public String Country;

}
