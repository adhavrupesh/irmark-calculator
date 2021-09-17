package com.example.paycaptainirmarkcalculator.fps;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class Email {
 @XmlAttribute(name = "Type")
 public String Type;
 @XmlAttribute(name = "Preferred")
 public String Preferred;
 @XmlValue
 public String text;

}