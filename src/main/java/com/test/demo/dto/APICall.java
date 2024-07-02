package com.test.demo.dto;

import jdk.jfr.DataAmount;

import java.time.LocalDateTime;

public class APICall {

    private LocalDateTime timestamp;

    public APICall() {
        this.timestamp = LocalDateTime.now();
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

}
