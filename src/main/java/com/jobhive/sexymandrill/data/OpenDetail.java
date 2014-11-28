package com.jobhive.sexymandrill.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenDetail {

    /**
     * the unix timestamp from when the message was opened/clicked
     */
    @JsonProperty("ts")
    private int timestamp;

    /**
     * the IP address that generated the open/click
     */
    private String ip;

    /**
     * the approximate region and country that the opening IP is located
     */
    private String location;

    /**
     * the email client or browser data of the open/click
     */
    @JsonProperty("ua")
    private String userAgent;

    public int getTimestamp() {
        return timestamp;
    }

    public OpenDetail setTimestamp(int timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public OpenDetail setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public OpenDetail setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public OpenDetail setUserAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }
}
