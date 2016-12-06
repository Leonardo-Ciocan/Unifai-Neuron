package com.unifai.model.payload;

import com.google.gson.JsonObject;

public class ImagePayload extends Payload {
    String imageUrl;
    String caption;
    String redirectUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }


    public ImagePayload(String imageUrl, String caption, String redirectUrl) {
        this.imageUrl = imageUrl;
        this.caption = caption;
        this.redirectUrl = redirectUrl;
    }

    @Override
    public JsonObject toJSON() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("caption", getCaption());
        jsonObject.addProperty("imageUrl", getImageUrl());
        jsonObject.addProperty("redirectUrl", getRedirectUrl());
        jsonObject.addProperty("type", PayloadType.Image.toString());
        return jsonObject;
    }
}
