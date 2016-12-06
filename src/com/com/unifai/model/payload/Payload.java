package com.unifai.model.payload;

import com.google.gson.JsonObject;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public abstract class Payload {
    public JsonObject toJSON() {
        throw new NotImplementedException();
    }
}
