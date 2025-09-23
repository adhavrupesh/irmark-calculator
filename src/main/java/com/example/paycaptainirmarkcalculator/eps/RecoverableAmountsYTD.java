package com.example.paycaptainirmarkcalculator.eps;

import jakarta.xml.bind.annotation.XmlElement;

public class RecoverableAmountsYTD {
 @XmlElement
 public String TaxMonth;
 @XmlElement
 public String SMPRecovered;
 @XmlElement
 public String SPPRecovered;
 @XmlElement
 public String SAPRecovered;
 @XmlElement
 public String ShPPRecovered;
 @XmlElement
 public String SPBPRecovered;
 @XmlElement
 public String NICCompensationOnSMP;
 @XmlElement
 public String NICCompensationOnSPP;
 @XmlElement
 public String NICCompensationOnSAP;
 @XmlElement
 public String NICCompensationOnShPP;
 @XmlElement
 public String NICCompensationOnSPBP;
 @XmlElement
 public String CISDeductionsSuffered;
}