package com.unifai.model.message;

import com.unifai.model.payload.Payload;

import java.util.HashMap;
import java.util.Map;

public class Message {
    private String body;
    private Map<String,Payload> payloads = new HashMap<>();

    public Message(String body) {
        this.body = body;
    }

    public Map<String, Payload> getPayloads() {
        return payloads;
    }

    public void setPayloads(Map<String, Payload> payloads) {
        this.payloads = payloads;
    }

    public void addPayload(String key, Payload value) {
        payloads.put(key, value);
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
