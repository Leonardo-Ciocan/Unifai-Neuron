package com.unifai.model.payload;

public class ImagePayload extends Payload {
    String imageUrl;

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

    String caption;
    String redirectUrl;

    public ImagePayload(String imageUrl, String caption, String redirectUrl) {
        this.imageUrl = imageUrl;
        this.caption = caption;
        this.redirectUrl = redirectUrl;
    }
}
