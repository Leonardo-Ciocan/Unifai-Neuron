package com.unifai.model.message;

import com.unifai.model.payload.EmptyPayload;

public class TextMessage extends Message {

    public TextMessage(String body) {
        super(body, MessageType.Text, new EmptyPayload());
    }
}
