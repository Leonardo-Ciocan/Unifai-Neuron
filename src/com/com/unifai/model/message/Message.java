package com.unifai.model.message;

import com.unifai.model.payload.Payload;

public abstract class Message {
    String body;
    Payload payload;
    MessageType type;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public Message(String body, MessageType type, Payload payload) {
        this.body = body;
        this.payload = payload;
        this.type = type;
    }

}
