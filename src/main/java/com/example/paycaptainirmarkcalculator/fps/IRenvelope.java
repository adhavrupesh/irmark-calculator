package com.example.paycaptainirmarkcalculator.fps;

import javax.xml.bind.annotation.XmlElement;

//@XmlType(namespace="http://www.govtalk.gov.uk/taxation/PAYE/RTI/FullPaymentSubmission/20-21/1")
public class IRenvelope {
    @XmlElement
    public IRheader IRheader;
    @XmlElement
    public com.example.paycaptainirmarkcalculator.fps.FullPaymentSubmission FullPaymentSubmission;

    //@XmlAttribute(name = "xmlns", namespace = "http://www.govtalk.gov.uk/taxation/PAYE/RTI/FullPaymentSubmission/20-21/1")
    //public String xmlns;

}