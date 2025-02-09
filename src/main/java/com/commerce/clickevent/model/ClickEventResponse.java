package com.commerce.clickevent.model;

public class ClickEventResponse {
    private int statusCode;
    private String status;
    private String timestamp;
    private String deviceId;

    public ClickEventResponse() {
    }

    public ClickEventResponse(int statusCode, String status, String timestamp, String deviceId) {
        this.statusCode = statusCode;
        this.status = status;
        this.timestamp = timestamp;
        this.deviceId = deviceId;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
