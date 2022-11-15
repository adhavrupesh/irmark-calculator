package com.example.paycaptainirmarkcalculator.service;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class PayCaptainRestClient {

    private WebClient webClient;

    public PayCaptainRestClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public void sendIRMarkWithXMLToPayCaptain(String xmlContent){
        String response = authorize();
    }

    public String authorize(){
        try {
            return webClient.post().uri(PayCaptainConstants.SANDBOX_AUTHORIZE_URL)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        } catch (WebClientResponseException ex) {
            System.out.println("Error Response code is: "+ex.getRawStatusCode()
                        +" and the message is: "+ex.getResponseBodyAsString());
            //System.out.println("WebClientResponseException in addNewEmployee"+ex);
            throw ex;
        } catch (Exception ex) {
            System.out.println("Exception in authorize(): "+ex.getMessage());
            throw ex;
        }
    }
}
