package com.unifai.model.message;

import com.google.gson.*;
import com.unifai.model.payload.ImagePayload;
import com.unifai.model.payload.Payload;
import com.unifai.model.payload.PayloadType;

import java.lang.reflect.Type;

import static com.unifai.model.payload.PayloadType.Image;

public class MessageDeserializer implements JsonDeserializer<Message> {

    @Override
    public Message deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String body = jsonObject.get("body").getAsString();

        Message msg = new Message(body);

        JsonObject payloads = jsonObject.getAsJsonObject("payloads");
        if(payloads != null) {
            payloads.entrySet().forEach(
                    entry -> msg.addPayload(entry.getKey(), objectToPayload(entry.getValue()))
            );
        }
        return msg;
    }

    private Payload objectToPayload(JsonElement jsonElement) {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        PayloadType type = PayloadType.values()[jsonObject.get("type").getAsInt()];
        switch (type) {
            case Image:
                String imageUrl = jsonObject.get("imageUrl").getAsString();
                String caption = jsonObject.get("caption").getAsString();
                String redirectUrl = jsonObject.get("redirectUrl").getAsString();

                return new ImagePayload(imageUrl, caption, redirectUrl);
        }
        return null;
    }

}
