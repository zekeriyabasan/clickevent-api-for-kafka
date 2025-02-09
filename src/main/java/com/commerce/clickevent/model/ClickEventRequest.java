package com.commerce.clickevent.model;

public class ClickEventRequest {
    private String customerId;
    private String city;
    private String deviceId;
    private String eventName;

    public ClickEventRequest() {
    }

    public ClickEventRequest(String city, String customerId, String deviceId, String eventName) {
        this.city = city;
        this.customerId = customerId;
        this.deviceId = deviceId;
        this.eventName = eventName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
