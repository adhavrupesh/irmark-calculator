package com.example.paycaptainirmarkcalculator.controller;

import com.example.paycaptainirmarkcalculator.IRMarkCalculator;
import com.example.paycaptainirmarkcalculator.service.PayCaptainResponseWrapper;
import com.example.paycaptainirmarkcalculator.service.PayCaptainRestClient;
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
    public void generateIRMark(String xmlContent) throws Exception {

        sleep(120);
        System.out.println("xmlContent started processing");

        InputStream targetStream = new ByteArrayInputStream(xmlContent.getBytes());
        IRMarkCalculator mc = new IRMarkCalculator();
        String base64 = mc.createMark(targetStream);
        System.out.println("output base64 : "+base64);

        if(base64 != "" && xmlContent.contains("<IRmark Type=\"generic\"></IRmark>")){
            xmlContent = xmlContent.replace("<IRmark Type=\"generic\"></IRmark>", "<IRmark Type=\"generic\">"+base64+"</IRmark>");
        }
        if(xmlContent.contains("\n")){
            xmlContent = xmlContent.replace("\n", "");
        }

        System.out.println("xmlContent processed");

        PayCaptainResponseWrapper payCaptainResponseWrapper = payCaptainRestClient.authorize();
        System.out.println("response: "+payCaptainResponseWrapper);

    }

    private void sleep(int args){
        try{
            TimeUnit.SECONDS.sleep(args);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
