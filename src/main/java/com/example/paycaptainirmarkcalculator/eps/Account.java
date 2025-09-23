package com.example.paycaptainirmarkcalculator.eps;

import jakarta.xml.bind.annotation.XmlElement;

public class Account {
 @XmlElement
 public String AccountHoldersName;
 @XmlElement
 public String AccountNo;
 @XmlElement
 public String SortCode;
 @XmlElement
 public String BuildingSocRef;
}