package com.example.withAngular.juice;

public class JuiceResponse {
   private String responseString = "";
   private String responseCode = "";
   public JuiceResponse withResponseCode(String responseCode) {
       this.responseCode = responseCode;
       return this;
   }
   public JuiceResponse withResponseString(String responseString) {
       this.responseString = responseString;
       return this;
   }
   public JuiceResponse build() {
       return this;
   }

    @Override
    public String toString() {
        return "JuiceResponse{" +
                "responseString='" + responseString + '\'' +
                ", responseCode='" + responseCode + '\'' +
                '}';
    }
}
