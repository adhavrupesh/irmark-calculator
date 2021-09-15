package com.example.paycaptainirmarkcalculator.fps;

import javax.xml.bind.annotation.XmlElement;

public class Payment {
    @XmlElement
    public String BacsHashCode;
    @XmlElement
    public String PayFreq;
    @XmlElement
    public String PmtDate;
    @XmlElement
    public String LateReason;
    @XmlElement
    public String MonthNo;
    @XmlElement
    public String PeriodsCovered;
    @XmlElement
    public String HoursWorked;
    @XmlElement
    public TaxCode TaxCode;
    @XmlElement
    public String TaxablePay;
    @XmlElement
    public String NonTaxOrNICPmt;
    @XmlElement
    public String PayAfterStatDedns;
    @XmlElement
    public String Class1ANICsYTD;
    @XmlElement
    public com.example.paycaptainirmarkcalculator.fps.Benefits Benefits;
    @XmlElement
    public StudentLoanRecovered StudentLoanRecovered;
    @XmlElement
    public String PostgradLoanRecovered;
    @XmlElement
    public String TaxDeductedOrRefunded;
    @XmlElement
    public String SPBPYTD;

}
