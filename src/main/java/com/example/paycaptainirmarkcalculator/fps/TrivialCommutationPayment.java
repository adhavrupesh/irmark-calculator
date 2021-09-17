package com.example.paycaptainirmarkcalculator.fps;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlValue;

public class TrivialCommutationPayment {
 @XmlAttribute(name = "type")
 public String type;
 @XmlValue
 public String text;
}