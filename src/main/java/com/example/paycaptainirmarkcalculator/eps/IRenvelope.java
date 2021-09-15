package com.example.paycaptainirmarkcalculator.eps;

import javax.xml.bind.annotation.XmlElement;

public class IRenvelope {
    @XmlElement
    public com.example.paycaptainirmarkcalculator.fps.IRheader IRheader;
    @XmlElement
    public EmployerPaymentSummary EmployerPaymentSummary;
}