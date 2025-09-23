package com.example.paycaptainirmarkcalculator.fps;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

public class Telephone {
 @XmlAttribute(name = "Type")
 public String Type;
 @XmlAttribute(name = "Mobile")
 public String Mobile;
 @XmlAttribute(name = "Preferred")
 public String Preferred;
 @XmlElement
 public String Number;
 @XmlElement
 public String Extension;

}