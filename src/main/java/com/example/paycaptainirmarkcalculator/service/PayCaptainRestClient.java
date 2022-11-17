package com.example.paycaptainirmarkcalculator.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    public String sendIRMarkToPayCaptain(String hmrcId) throws JsonProcessingException {

        System.out.println("sendIRMarkToPayCaptain");
        System.out.println("hmrcId: "+hmrcId);
        try {
            /*Map<String, String> mp = new HashMap();
            mp.put("xmlContent", xmlContent);
            mp.put("hmrcId", hmrcId);

            ObjectMapper objectMapper = new ObjectMapper();
            xmlContent = objectMapper.writeValueAsString(mp);*/

            return webClient.patch()
                    .uri(PayCaptainConstants.SANDBOX_WEBHOOK_URL)
                    .body(hmrcId, String.class)
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
}
