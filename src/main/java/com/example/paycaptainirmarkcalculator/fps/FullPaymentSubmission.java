package com.example.paycaptainirmarkcalculator.fps;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class FullPaymentSubmission {
    @XmlElement
    public EmpRefs EmpRefs;
    @XmlElement
    public String RelatedTaxYear;
    @XmlElement
    public List<Employee> Employee;
    @XmlElement
    public FinalSubmission FinalSubmission;

}