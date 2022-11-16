package com.example.paycaptainirmarkcalculator.service;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PayCaptainResponseWrapper {

    @JsonProperty("access_token")
    private String access_token;

    @JsonProperty("signature")
    private String signature;

    @JsonProperty("scope")
    private String scope;

    @JsonProperty("instance_url")
    private String instance_url;

    @JsonProperty("id")
    private String id;

    @JsonProperty("token_type")
    private String token_type;

    @JsonProperty("issued_at")
    private String issued_at;

}
