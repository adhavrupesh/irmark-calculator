package com.example.paycaptainirmarkcalculator.controller;

import com.example.paycaptainirmarkcalculator.IRMarkCalculator;
import com.example.paycaptainirmarkcalculator.service.PayCaptainResponseWrapper;
import com.example.paycaptainirmarkcalculator.service.PayCaptainRestClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

@Service
public class AsynController{

    WebClient webClient = WebClient.create();
    PayCaptainRestClient payCaptainRestClient = new PayCaptainRestClient(webClient);

    @Async
    public void generateFPSIRMark(String xmlContent, String taxYear, String endDateMonth, String hmrcId, String isSandbox) throws Exception {

        sleep(120);
        System.out.println("fps xmlContent started processing");

        if(xmlContent.contains("<MessageDetailsClass>")) {
            xmlContent = xmlContent.replace("<MessageDetailsClass>", "<Class>");
            xmlContent = xmlContent.replace("</MessageDetailsClass>", "</Class>");
        }
        if(xmlContent.contains("<IRenvelope>")){
            xmlContent = xmlContent.replace("<IRenvelope>",
                    "<IRenvelope xmlns=\"http://www.govtalk.gov.uk/taxation/PAYE/RTI/FullPaymentSubmission/"+taxYear+"/"+endDateMonth+"\">");
        }
        if(xmlContent.contains(" standalone=\"yes\"")){
            xmlContent = xmlContent.replace(" standalone=\"yes\"", "");
        }
        if(xmlContent.contains("\n")){
            xmlContent = xmlContent.replace("\n", "");
        }

        //added on 09 December 2021
        if(xmlContent.contains("NIlettersAndValuesB")){
            xmlContent = xmlContent.replace("NIlettersAndValuesB", "NIlettersAndValues");
        }
        if(xmlContent.contains("NIlettersAndValuesC")){
            xmlContent = xmlContent.replace("NIlettersAndValuesC", "NIlettersAndValues");
        }
        if(xmlContent.contains("NIlettersAndValuesH")){
            xmlContent = xmlContent.replace("NIlettersAndValuesH", "NIlettersAndValues");
        }
        if(xmlContent.contains("NIlettersAndValuesJ")){
            xmlContent = xmlContent.replace("NIlettersAndValuesJ", "NIlettersAndValues");
        }
        if(xmlContent.contains("NIlettersAndValuesM")){
            xmlContent = xmlContent.replace("NIlettersAndValuesM", "NIlettersAndValues");
        }
        if(xmlContent.contains("NIlettersAndValuesX")){
            xmlContent = xmlContent.replace("NIlettersAndValuesX", "NIlettersAndValues");
        }
        if(xmlContent.contains("NIlettersAndValuesZ")){
            xmlContent = xmlContent.replace("NIlettersAndValuesZ", "NIlettersAndValues");
        }


        InputStream targetStream = new ByteArrayInputStream(xmlContent.getBytes());
        IRMarkCalculator mc = new IRMarkCalculator();
        String base64 = mc.createMark(targetStream);
        System.out.println("fps output base64 : "+base64);

        if(base64 != "" && xmlContent.contains("<IRmark Type=\"generic\"></IRmark>")){
            xmlContent = xmlContent.replace("<IRmark Type=\"generic\"></IRmark>", "<IRmark Type=\"generic\">"+base64+"</IRmark>");
        }
        if(xmlContent.contains("\n")){
            xmlContent = xmlContent.replace("\n", "");
        }
        System.out.println("fps xmlContent processed");

        String response = payCaptainRestClient.sendIRMarkToPayCaptain(xmlContent, hmrcId, isSandbox);
        System.out.println("fps response: "+response);

    }

    @Async
    public void generateEPSIRMark(String xmlContent, String taxYear, String endDateMonth, String hmrcId, String isSandbox) throws Exception {

        sleep(120);
        System.out.println("eps xmlContent started processing");

        if(xmlContent.contains("<MessageDetailsClass>")) {
            xmlContent = xmlContent.replace("<MessageDetailsClass>", "<Class>");
            xmlContent = xmlContent.replace("</MessageDetailsClass>", "</Class>");
        }
        if(xmlContent.contains("<IRenvelope>")){
            xmlContent = xmlContent.replace("<IRenvelope>",
                    "<IRenvelope xmlns=\"http://www.govtalk.gov.uk/taxation/PAYE/RTI/EmployerPaymentSummary/"+taxYear+"/"+endDateMonth+"\">");
        }
        if(xmlContent.contains(" standalone=\"yes\"")){
            xmlContent = xmlContent.replace(" standalone=\"yes\"", "");
        }
        if(xmlContent.contains("\n")){
            xmlContent = xmlContent.replace("\n", "");
        }

        InputStream targetStream = new ByteArrayInputStream(xmlContent.getBytes());
        IRMarkCalculator mc = new IRMarkCalculator();
        String base64 = mc.createMark(targetStream);
        System.out.println("eps output base64 : "+base64);

        if(base64 != "" && xmlContent.contains("<IRmark Type=\"generic\"></IRmark>")){
            xmlContent = xmlContent.replace("<IRmark Type=\"generic\"></IRmark>", "<IRmark Type=\"generic\">"+base64+"</IRmark>");
        }
        if(xmlContent.contains("\n")){
            xmlContent = xmlContent.replace("\n", "");
        }

        System.out.println("eps xmlContent processed");

        String response = payCaptainRestClient.sendIRMarkToPayCaptain(xmlContent, hmrcId, isSandbox);
        System.out.println("eps response: "+response);
    }


     @Async
    public void generateAgentAuthIRMark(String xmlContent, String hmrcId, String accountId, String isSandbox) throws Exception {

        sleep(120);
        System.out.println("agentauth xmlContent started processing");

        if(xmlContent.contains("<MessageDetailsClass>")) {
            xmlContent = xmlContent.replace("<MessageDetailsClass>", "<Class>");
        }
        if(xmlContent.contains("<IRenvelope>")){
            xmlContent = xmlContent.replace("<IRenvelope>",
                    "<IRenvelope xmlns=\"http://www.govtalk.gov.uk/taxation/AgentAuthRequest/1\">");
        }
        if(xmlContent.contains("\n")){
            xmlContent = xmlContent.replace("\n", "");
        }

        InputStream targetStream = new ByteArrayInputStream(xmlContent.getBytes());
        IRMarkCalculator mc = new IRMarkCalculator();
        String base64 = mc.createMark(targetStream);
        System.out.println("agentauth output base64 : "+base64);

        if(base64 != "" && xmlContent.contains("<IRmark Type=\"generic\"></IRmark>")){
            xmlContent = xmlContent.replace("<IRmark Type=\"generic\"></IRmark>", "<IRmark Type=\"generic\">"+base64+"</IRmark>");
        }
        if(xmlContent.contains("\n")){
            xmlContent = xmlContent.replace("\n", "");
        }
        System.out.println("agentauth xmlContent processed");

        String response = payCaptainRestClient.sendIRMarkToPayCaptainAgentAuth(xmlContent, hmrcId, accountId, isSandbox, base64);
        System.out.println("agentauth response: "+response);

    }

    private void sleep(int args){
        try{
            TimeUnit.SECONDS.sleep(args);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }










    // use this functions for editing and testing code.
    @Async
    public void generateFPSIRMarkTest(String xmlContent, String taxYear, String endDateMonth, String hmrcId, String key, String isSandbox) throws Exception {

        sleep(120);
        System.out.println("Test fps xmlContent started processing");

        if(xmlContent.contains("<MessageDetailsClass>")) {
            xmlContent = xmlContent.replace("<MessageDetailsClass>", "<Class>");
            xmlContent = xmlContent.replace("</MessageDetailsClass>", "</Class>");
        }
        if(xmlContent.contains("<IRenvelope>")){
            xmlContent = xmlContent.replace("<IRenvelope>",
                    "<IRenvelope xmlns=\"http://www.govtalk.gov.uk/taxation/PAYE/RTI/FullPaymentSubmission/"+taxYear+"/"+endDateMonth+"\">");
        }
        if(xmlContent.contains(" standalone=\"yes\"")){
            xmlContent = xmlContent.replace(" standalone=\"yes\"", "");
        }
        if(xmlContent.contains("\n")){
            xmlContent = xmlContent.replace("\n", "");
        }

        //added on 09 December 2021
        if(xmlContent.contains("NIlettersAndValuesB")){
            xmlContent = xmlContent.replace("NIlettersAndValuesB", "NIlettersAndValues");
        }
        if(xmlContent.contains("NIlettersAndValuesC")){
            xmlContent = xmlContent.replace("NIlettersAndValuesC", "NIlettersAndValues");
        }
        if(xmlContent.contains("NIlettersAndValuesH")){
            xmlContent = xmlContent.replace("NIlettersAndValuesH", "NIlettersAndValues");
        }
        if(xmlContent.contains("NIlettersAndValuesJ")){
            xmlContent = xmlContent.replace("NIlettersAndValuesJ", "NIlettersAndValues");
        }
        if(xmlContent.contains("NIlettersAndValuesM")){
            xmlContent = xmlContent.replace("NIlettersAndValuesM", "NIlettersAndValues");
        }
        if(xmlContent.contains("NIlettersAndValuesX")){
            xmlContent = xmlContent.replace("NIlettersAndValuesX", "NIlettersAndValues");
        }
        if(xmlContent.contains("NIlettersAndValuesZ")){
            xmlContent = xmlContent.replace("NIlettersAndValuesZ", "NIlettersAndValues");
        }


        InputStream targetStream = new ByteArrayInputStream(xmlContent.getBytes());
        IRMarkCalculator mc = new IRMarkCalculator();
        String base64 = mc.createMark(targetStream);
        System.out.println("Test fps output base64 : "+base64);

        if(base64 != "" && xmlContent.contains("<IRmark Type=\"generic\"></IRmark>")){
            xmlContent = xmlContent.replace("<IRmark Type=\"generic\"></IRmark>", "<IRmark Type=\"generic\">"+base64+"</IRmark>");
        }
        if(xmlContent.contains("\n")){
            xmlContent = xmlContent.replace("\n", "");
        }
        System.out.println("Test fps xmlContent processed");

        String response = payCaptainRestClient.sendIRMarkToPayCaptainTest(xmlContent, hmrcId, key, isSandbox);
        System.out.println("Test fps response: "+response);

    }

}
