@XmlSchema(
        namespace = "http://www.govtalk.gov.uk/CM/envelope",
        elementFormDefault = XmlNsForm.QUALIFIED
        /*xmlns = {
                @XmlNs(prefix = "", namespaceURI = "hhttp://www.govtalk.gov.uk/CM/envelope"),
                @XmlNs(prefix = "", namespaceURI = "http://www.govtalk.gov.uk/taxation/PAYE/RTI/FullPaymentSubmission/20-21/1")
        }*/
)

package com.example.paycaptainirmarkcalculator.eps;

import jakarta.xml.bind.annotation.XmlNsForm;
import jakarta.xml.bind.annotation.XmlSchema;