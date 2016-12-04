package com.unifai.model.message;

import com.google.gson.*;
import com.unifai.model.payload.ImagePayload;

import java.lang.reflect.Type;

public class MessageSerializer implements JsonSerializer<Message> {

    @Override
    public JsonElement serialize(Message message, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("body", message.getBody());
        jsonObject.addProperty("type", message.getType().value);
        JsonObject payloadElement = new JsonObject();
        jsonObject.add("payload", payloadElement);
        switch (message.getType()) {
            case Image:
                ImagePayload imagePayload = (ImagePayload)message.getPayload();
                payloadElement.addProperty("caption", imagePayload.getCaption());
                payloadElement.addProperty("imageUrl", imagePayload.getImageUrl());
                payloadElement.addProperty("redirectUrl", imagePayload.getRedirectUrl());
                break;
        }
        return jsonObject;
    }

}
