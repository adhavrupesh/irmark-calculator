package com.example.paycaptainirmarkcalculator.fps;

import javax.xml.bind.annotation.XmlElement;

public class EmployeeDetails {
    @XmlElement
    public String NINO;
    @XmlElement
    public com.example.paycaptainirmarkcalculator.fps.Name Name;
    @XmlElement
    public Address Address;
    @XmlElement
    public String BirthDate;
    @XmlElement
    public String Gender;

}
