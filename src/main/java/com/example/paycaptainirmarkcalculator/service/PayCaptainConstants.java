package com.example.paycaptainirmarkcalculator.service;

public class PayCaptainConstants {
    //PayCaptain sandbox credentials and urls

    public static final String CLIENT_ID = "3MVG9od6vNol.eBh2ig4mdGAEEQoVDKdQ6svzuGEgGvuMs4.GceA25dhSDKbTn_j_RuTR0ECPqHCUzL1MyKkA";
    public static final String CLIENT_SECRET = "38D53D874B02923E6C59E481A4E05593EFB9683E7CA5A06FC18A8C2C452B4CD2";

    public static final String SANDBOX_DEV_URL = "https://paycaptain--dev.sandbox.lightning.force.com";
    public static final String SANDBOX_DOMAIN_URL = "https://paycaptain--dev.sandbox.my.salesforce.com";

    public static final String SANDBOX_ACCESS_TOKEN_URL = "https://paycaptain--dev.sandbox.my.salesforce.com/services/oauth2/token?"
            +"&grant_type=client_credentials"
            +"&client_id="+CLIENT_ID
            +"&client_secret="+CLIENT_SECRET;

    public static final String SANDBOX_QUERY_URL = "https://paycaptain--dev.sandbox.my.salesforce.com/services/data/v41.0/query";





    //PayCaptain production credentials and urls

    public static final String PRODUCTION_AUTHORIZE_URL = "https://paycaptain--dev.sandbox.lightning.force.com/services/oauth2/authorize";
    public static final String PRODUCTION_TOKEN_URL = "https://paycaptain--dev.sandbox.my.salesforce.com/services/oauth2/token";
    public static final String PRODUCTION_QUERY_URL = "https://paycaptain--dev.sandbox.my.salesforce.com/services/data/v41.0/query";

}
