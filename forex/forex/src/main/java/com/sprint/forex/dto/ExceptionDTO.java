package com.sprint.forex.dto;

public class ExceptionDTO {
    private boolean isSuccess;
    private String message;

    public ExceptionDTO(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public ExceptionDTO() {
    }
    public ExceptionDTO(String message) {
        this.isSuccess = false;
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
