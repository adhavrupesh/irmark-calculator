package com.example.paycaptainirmarkcalculator.fps;

import javax.xml.bind.annotation.XmlElement;

public class FullPaymentSubmission {
    @XmlElement
    public EmpRefs EmpRefs;
    @XmlElement
    public String RelatedTaxYear;
    @XmlElement
    public Employee Employee;

}