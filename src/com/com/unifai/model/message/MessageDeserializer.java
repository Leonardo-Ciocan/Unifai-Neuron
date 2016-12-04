package com.unifai.model.message;

import com.google.gson.*;

import java.lang.reflect.Type;

public class MessageDeserializer implements JsonDeserializer<Message> {

    @Override
    public Message deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String body = jsonObject.get("body").getAsString();
        MessageType msgType = MessageType.values()[jsonObject.get("type").getAsInt()];
        switch (msgType) {
            case Text:
                return new TextMessage(body);
        }
        return null;
    }

}
