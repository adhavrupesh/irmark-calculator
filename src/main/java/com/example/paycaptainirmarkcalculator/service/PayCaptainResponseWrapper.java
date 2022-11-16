package com.example.paycaptainirmarkcalculator.service;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PayCaptainResponseWrapper {

    @JsonProperty("access_token")
    public String access_token;

    @JsonProperty("signature")
    public String signature;

    @JsonProperty("scope")
    public String scope;

    @JsonProperty("instance_url")
    public String instance_url;

    @JsonProperty("id")
    public String id;

    @JsonProperty("token_type")
    public String token_type;

    @JsonProperty("issued_at")
    public String issued_at;

}
