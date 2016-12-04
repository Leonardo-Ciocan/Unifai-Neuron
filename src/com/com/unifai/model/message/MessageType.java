package com.unifai.model.message;

public enum MessageType {
    Text(0),
    Image(1),
    Prompt(2);

    public final int value;

    private MessageType(int value) {
        this.value = value;
    }
}
