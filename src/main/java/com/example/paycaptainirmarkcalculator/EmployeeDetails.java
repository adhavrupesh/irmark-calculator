package com.example.paycaptainirmarkcalculator;

import javax.xml.bind.annotation.XmlElement;

public class EmployeeDetails {
    @XmlElement
    public String NINO;
    @XmlElement
    public Name Name;
    @XmlElement
    public Address Address;
    @XmlElement
    public String BirthDate;
    @XmlElement
    public String Gender;

}
