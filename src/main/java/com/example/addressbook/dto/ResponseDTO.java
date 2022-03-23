package com.example.addressbook.dto;

public class ResponseDTO {
    private String message;
    private  Object object;
    private String token;

    public ResponseDTO(String message, Object addressBookDTO,String token){
        this.message = message;
        this.object = addressBookDTO;
        this.token = token;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "message = " + message + '\'' +
                "object= " + object +
                "token = "   + token +'}';
    }
}
