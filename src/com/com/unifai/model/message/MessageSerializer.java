package com.unifai.model.message;

import com.google.gson.*;
import com.unifai.model.payload.ImagePayload;
import com.unifai.model.payload.Payload;

import java.lang.reflect.Type;
import java.util.Map;

public class MessageSerializer implements JsonSerializer<Message> {

    @Override
    public JsonElement serialize(Message message, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("body", message.getBody());
        JsonObject payloadElement = new JsonObject();
        message.getPayloads().entrySet().forEach(
                e -> payloadElement.add(e.getKey(), e.getValue().toJSON())
        );
        jsonObject.add("payloads", payloadElement);
        return jsonObject;
    }

}
