package com.example.paycaptainirmarkcalculator.eps;

import javax.xml.bind.annotation.XmlElement;

public class EmployerPaymentSummary {
   @XmlElement
   public EmpRefs EmpRefs;
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
}
