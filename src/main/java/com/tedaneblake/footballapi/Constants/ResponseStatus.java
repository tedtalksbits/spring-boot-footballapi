package com.tedaneblake.footballapi.Constants;

public enum ResponseStatus {
    SUCCESS("success"), ERROR("error");

    private String status;

    private ResponseStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status.toLowerCase();
    }
}
