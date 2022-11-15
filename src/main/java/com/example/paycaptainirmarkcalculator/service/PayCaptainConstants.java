package com.example.paycaptainirmarkcalculator.service;

public class PayCaptainConstants {
    public static final String CLIENT_ID = "3MVG9od6vNol.eBh2ig4mdGAEEQoVDKdQ6svzuGEgGvuMs4.GceA25dhSDKbTn_j_RuTR0ECPqHCUzL1MyKkA";
    public static final String CLIENT_SECRET = "38D53D874B02923E6C59E481A4E05593EFB9683E7CA5A06FC18A8C2C452B4CD2";

    public static final String SANDBOX_AUTHORIZE_URL = "https://paycaptain--dev.sandbox.lightning.force.com/services/oauth2/authorize?"
            +"&client_id="+CLIENT_ID
            +"&redirect_uri=https://www.google.com"
            +"&response_type=code";

    public static final String SANDBOX_TOKEN_URL = "https://paycaptain--dev.sandbox.my.salesforce.com/services/oauth2/token?"
            +"&grant_type=authorization_code"
            +"&client_id="+CLIENT_ID
            +"&client_secret="+CLIENT_SECRET
            +"&redirect_uri=https://www.google.com/";
            //+"&code=";

    public static final String SANDBOX_QUERY_URL = "https://paycaptain--dev.sandbox.my.salesforce.com/services/data/v41.0/query";

    public static final String PRODUCTION_AUTHORIZE_URL = "https://paycaptain--dev.sandbox.lightning.force.com/services/oauth2/authorize";
    public static final String PRODUCTION_TOKEN_URL = "https://paycaptain--dev.sandbox.my.salesforce.com/services/oauth2/token";
    public static final String PRODUCTION_QUERY_URL = "https://paycaptain--dev.sandbox.my.salesforce.com/services/data/v41.0/query";

}
