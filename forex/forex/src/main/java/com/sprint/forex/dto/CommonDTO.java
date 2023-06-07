package com.sprint.forex.dto;

public class CommonDTO<T> {
    private boolean isSuccess;
    private String message;
    private T data;

    public CommonDTO(boolean isSuccess, String message, T data) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.data = data;
    }

    public CommonDTO(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.data = null;
    }

    public CommonDTO(String message, T data) {
        this.message = message;
        this.isSuccess =true;
        this.data = data;
    }

    public CommonDTO() {
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
