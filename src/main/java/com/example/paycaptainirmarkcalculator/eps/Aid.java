package com.example.paycaptainirmarkcalculator.eps;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Aid {
 @XmlAttribute(name = "Cur")
 public String Cur;
 @XmlElement
 public String text;
}