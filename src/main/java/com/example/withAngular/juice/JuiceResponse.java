package com.example.withAngular.juice;

public class JuiceResponse {
   private String responseString ;
   private String responseCode ;

    JuiceResponse(String responseString, String responseCode) {
        this.responseString = responseString;
        this.responseCode = responseCode;
    }

    public String getResponseString() {
        return responseString;
    }

    public void setResponseString(String responseString) {
        this.responseString = responseString;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
}
