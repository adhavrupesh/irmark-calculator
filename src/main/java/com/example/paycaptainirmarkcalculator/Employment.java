package com.example.paycaptainirmarkcalculator;

import javax.xml.bind.annotation.XmlElement;

public class Employment {
    @XmlElement
    public String OffPayrollWorker;
    @XmlElement
    public String PayId;
    @XmlElement
    public String IrrEmp;
    @XmlElement
    public String LeavingDate;
    @XmlElement
    public FiguresToDate FiguresToDate;
    @XmlElement
    public Payment Payment;
    @XmlElement
    public NIlettersAndValues NIlettersAndValues;

}
