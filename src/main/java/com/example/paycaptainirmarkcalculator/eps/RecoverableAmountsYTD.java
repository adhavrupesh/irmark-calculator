package com.example.paycaptainirmarkcalculator.eps;

import javax.xml.bind.annotation.XmlElement;

public class RecoverableAmountsYTD {
 @XmlElement
 public String SPPRecovered;
 @XmlElement
 public String ShPPRecovered;
 @XmlElement
 public String SPBPRecovered;
 @XmlElement
 public String NICCompensationOnSPP;
 @XmlElement
 public String NICCompensationOnShPP;
 @XmlElement
 public String NICCompensationOnSPBP;
}