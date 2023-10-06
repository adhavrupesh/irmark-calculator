package com.example.paycaptainirmarkcalculator.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.sql.Blob;
import java.util.HashMap;
import java.util.Map;

public class PayCaptainRestClient {

    private WebClient webClient;

    public PayCaptainRestClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public String sendIRMarkToPayCaptain(String xmlContent, String hmrcId, String isSandbox) throws JsonProcessingException {
        System.out.println("sendIRMarkToPayCaptain");
        System.out.println("hmrcId: "+hmrcId);

        try {

            String webhookUrl = isSandbox.equalsIgnoreCase("Yes") ? PayCaptainConstants.SANDBOX_WEBHOOK_URL : PayCaptainConstants.PRODUCTION_WEBHOOK_URL;
            System.out.println("webhookUrl: "+webhookUrl);

            Map<String, String> mp = new HashMap();
            mp.put("xmlContent", xmlContent);
            mp.put("hmrcId", hmrcId);

            ObjectMapper objectMapper = new ObjectMapper();
            String bodyValue = objectMapper.writeValueAsString(mp);

            return webClient.patch()
                    .uri(webhookUrl)
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .bodyValue(bodyValue)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

        } catch (WebClientResponseException ex) {
            System.out.println("Error Response code is: "+ex.getRawStatusCode()+" and the message is: "+ex.getResponseBodyAsString());
            throw ex;

        } catch (Exception ex) {
            System.out.println("Exception in sendIRMarkToPayCaptain(): "+ex.getMessage());
            throw ex;

        }
    }










    // use this functions for editing and testing code.
    public String sendIRMarkToPayCaptainTest(String xmlContent, String hmrcId, String key, String isSandbox) throws JsonProcessingException {
        System.out.println("Test sendIRMarkToPayCaptain");
        System.out.println("Test hmrcId: "+hmrcId);

        try {

            String webhookUrl = PayCaptainConstants.FULL_COPY_SANDBOX_WEBHOOK_URL;
            System.out.println("Test webhookUrl: "+webhookUrl);

            Map<String, String> mp = new HashMap();
            mp.put("xmlContent", xmlContent);
            mp.put("key", key);
            mp.put("hmrcId", hmrcId);

            ObjectMapper objectMapper = new ObjectMapper();
            String bodyValue = objectMapper.writeValueAsString(mp);

            return webClient.patch()
                    .uri(webhookUrl)
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .bodyValue(bodyValue)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

        } catch (WebClientResponseException ex) {
            System.out.println("Test Error Response code is: "+ex.getRawStatusCode()+" and the message is: "+ex.getResponseBodyAsString());
            throw ex;

        } catch (Exception ex) {
            System.out.println("Test Exception in sendIRMarkToPayCaptain(): "+ex.getMessage());
            throw ex;

        }
    }
}
