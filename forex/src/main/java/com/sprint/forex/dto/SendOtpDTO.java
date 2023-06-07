package com.sprint.forex.dto;

public class SendOtpDTO {
    private String email;

    public SendOtpDTO() {
    }

    public SendOtpDTO(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
