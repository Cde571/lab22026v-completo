package com.udea.lab2026v.dto;

public class ApiMessageDTO {

    private String message;

    public ApiMessageDTO() {
    }

    public ApiMessageDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
