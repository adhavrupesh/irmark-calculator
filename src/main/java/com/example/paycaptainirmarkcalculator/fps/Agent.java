package com.example.paycaptainirmarkcalculator.fps;

import jakarta.xml.bind.annotation.XmlElement;

public class Agent {
 @XmlElement
 public String AgentID;
 @XmlElement
 public String Company;
 @XmlElement
 public Address Address;
 @XmlElement
 public Contact Contact;
}