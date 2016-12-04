package com.unifai.model.message;

import com.unifai.model.payload.ImagePayload;

public class ImageMessage extends Message{
    public ImageMessage(String body, String imageCaption, String imageUrl, String redirectUrl ) {
        super(body, MessageType.Image, new ImagePayload(imageUrl, imageCaption, redirectUrl));
    }
}
