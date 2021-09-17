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
    public String WeekNo;
    @XmlElement
    public String PeriodsCovered;
    @XmlElement
    public String AggregatedEarnings;
    @XmlElement
    public String PmtAfterLeaving;
    @XmlElement
    public String HoursWorked;
    @XmlElement
    public TaxCode TaxCode;
    @XmlElement
    public String TaxablePay;
    @XmlElement
    public String NonTaxOrNICPmt;
    @XmlElement
    public String DednsFromNetPay;
    @XmlElement
    public String PayAfterStatDedns;
    @XmlElement
    public String BenefitsTaxedViaPayroll;
    @XmlElement
    public String Class1ANICsYTD;
    @XmlElement
    public com.example.paycaptainirmarkcalculator.fps.Benefits Benefits;
    @XmlElement
    public String EmpeePenContribnsPaid;
    @XmlElement
    public String ItemsSubjectToClass1NIC;
    @XmlElement
    public String EmpeePenContribnsNotPaid;
    @XmlElement
    public StudentLoanRecovered StudentLoanRecovered;
    @XmlElement
    public String PostgradLoanRecovered;
    @XmlElement
    public String TaxDeductedOrRefunded;
    @XmlElement
    public String OnStrike;
    @XmlElement
    public String UnpaidAbsence;
    @XmlElement
    public String SMPYTD;
    @XmlElement
    public String SPPYTD;
    @XmlElement
    public String SAPYTD;
    @XmlElement
    public String ShPPYTD;
    @XmlElement
    public String SPBPYTD;
    @XmlElement
    public TrivialCommutationPayment TrivialCommutationPayment;
    @XmlElement
    public FlexibleDrawdown FlexibleDrawdown;

}
