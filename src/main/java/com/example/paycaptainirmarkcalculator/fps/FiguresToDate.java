package com.example.paycaptainirmarkcalculator.fps;

import javax.xml.bind.annotation.XmlElement;

public class FiguresToDate {
    @XmlElement
    public String TaxablePay;
    @XmlElement
    public String TotalTax;
    @XmlElement
    public String StudentLoansTD;
    @XmlElement
    public String PostgradLoansTD;
    @XmlElement
    public String BenefitsTaxedViaPayrollYTD;
    @XmlElement
    public String EmpeePenContribnsPaidYTD;
    @XmlElement
    public String EmpeePenContribnsNotPaidYTD;

}