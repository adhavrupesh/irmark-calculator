package com.example.paycaptainirmarkcalculator.fps;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlValue;

public class TrivialCommutationPayment {
 @XmlAttribute(name = "type")
 public String type;
 @XmlValue
 public String text;
}