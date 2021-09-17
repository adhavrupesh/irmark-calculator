package com.example.paycaptainirmarkcalculator.eps;

import com.example.paycaptainirmarkcalculator.fps.FinalSubmission;

import javax.xml.bind.annotation.XmlElement;

public class EmployerPaymentSummary {
   @XmlElement
   public EmpRefs EmpRefs;
   @XmlElement
   public PeriodOfInactivity PeriodOfInactivity;
   @XmlElement
   public String EmpAllceInd;
   @XmlElement
   public DeMinimisStateAid DeMinimisStateAid;
   @XmlElement
   public RecoverableAmountsYTD RecoverableAmountsYTD;
   @XmlElement
   public ApprenticeshipLevy ApprenticeshipLevy;
   @XmlElement
   public Account Account;
   @XmlElement
   public String RelatedTaxYear;
   @XmlElement
   public com.example.paycaptainirmarkcalculator.fps.FinalSubmission FinalSubmission;
}
