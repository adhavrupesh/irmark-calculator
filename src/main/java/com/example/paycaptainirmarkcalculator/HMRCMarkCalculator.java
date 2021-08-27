package com.example.paycaptainirmarkcalculator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class HMRCMarkCalculator extends MarkCalculator {
	

    @Override
    public String getAlgorithm() {


        String transformStr =
                "<?xml version='1.0'?>\n"
                        + "<dsig:Transforms xmlns:dsig='http://www.w3.org/2000/09/xmldsig#' xmlns:soap='http://www.w3.org/2003/05/soap-envelope'>\n"
                        + "<dsig:Transform Algorithm='http://www.w3.org/TR/1999/REC-xpath-19991116'>\n"
                        + "<dsig:XPath>\n"
                        + "count(ancestor-or-self::node()|/soap:Envelope/soap:Body)=count(ancestor-or-self::node())\n"
                        + "</dsig:XPath>\n"
                        + "</dsig:Transform>\n"
                        + "<dsig:Transform Algorithm='http://www.w3.org/TR/2001/REC-xml-c14n-20010315#WithComments'/>\n"
                        + "</dsig:Transforms>\n"
                ;

        return transformStr;
    }


}