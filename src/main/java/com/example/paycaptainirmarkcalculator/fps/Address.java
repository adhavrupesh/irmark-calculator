package com.example.paycaptainirmarkcalculator.fps;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Address {
    @XmlElement
    public List<String> Line;
    @XmlElement
    public String UKPostcode;

}
