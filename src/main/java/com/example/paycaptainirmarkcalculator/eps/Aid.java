package com.example.paycaptainirmarkcalculator.eps;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

public class Aid {
 @XmlAttribute(name = "Cur")
 public String Cur;
 @XmlElement
 public String text;
}