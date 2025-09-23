package com.example.paycaptainirmarkcalculator.fps;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;

public class Email {
 @XmlAttribute(name = "Type")
 public String Type;
 @XmlAttribute(name = "Preferred")
 public String Preferred;
 @XmlValue
 public String text;

}