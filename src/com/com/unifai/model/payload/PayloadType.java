package com.unifai.model.payload;

public enum PayloadType {
    Image(0);

    public final int value;

    private PayloadType(int value) {
        this.value = value;
    }
}
