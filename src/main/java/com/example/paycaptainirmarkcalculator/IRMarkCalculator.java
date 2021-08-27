package com.example.paycaptainirmarkcalculator;

import io.micrometer.core.instrument.util.IOUtils;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.nio.charset.StandardCharsets;

import org.springframework.core.io.Resource;


public class IRMarkCalculator extends MarkCalculator {


    @Override
    public String getAlgorithm() {

        String transformStr = "<?xml version='1.0'?>\n"
                        + "<dsig:Transforms xmlns:dsig='http://www.w3.org/2000/09/xmldsig#' xmlns:gt='http://www.govtalk.gov.uk/CM/envelope'>\n"
                        + "<dsig:Transform Algorithm='http://www.w3.org/TR/1999/REC-xpath-19991116'>\n"
                        + "<dsig:XPath>\n"
                        + "(count(ancestor-or-self::node()|/gt:GovTalkMessage/gt:Body)=count(ancestor-or-self::node()))\n"
                        + " and \n"
                        + "(count(ancestor-or-self::node()|/gt:GovTalkMessage/gt:Body/*[name()='IRenvelope']/*[name()='IRheader']/*[name()='IRmark'])!=count(ancestor-or-self::node()))\n"
                        + "</dsig:XPath>\n"
                        + "</dsig:Transform>\n"
                        + "<dsig:Transform Algorithm='http://www.w3.org/TR/2001/REC-xml-c14n-20010315#WithComments'/>\n"
                        + "</dsig:Transforms>\n"
                ;

        return transformStr;
    }


}