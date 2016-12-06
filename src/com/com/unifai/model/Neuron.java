package com.unifai.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.unifai.model.message.Message;
import com.unifai.model.message.MessageDeserializer;
import com.unifai.model.message.MessageSerializer;
import spark.Spark;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static spark.Spark.get;
import static spark.Spark.post;

public abstract class Neuron {

    private static final String UNIFAI_ENDPOINT = "/unifai";
    private static final String INFO_ENDPOINT = "/info";
    private static final String SEND_ENDPOINT = "/send";

    private Gson gson;

    public Neuron() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Message.class, new MessageSerializer());
        gsonBuilder.registerTypeAdapter(Message.class, new MessageDeserializer());
        gson = gsonBuilder.create();
    }

    public String getName() {
        throw new NotImplementedException();
    }

    public String getKeyword() {
        return getName().toLowerCase();
    }

    public String getColor() {
        throw new NotImplementedException();
    }

    public Message respondToMessage(Message message) {
        throw new NotImplementedException();
    }

    public String extractIntentFromMessage()  {
        throw new NotImplementedException();
    }

    public void start() {
        get(UNIFAI_ENDPOINT, (req,res) -> "0.1");
        get(INFO_ENDPOINT, (req, res) -> printInfo());
        post(SEND_ENDPOINT, (req, res) -> {
            Message response = respondToMessage(convertMessage(req.body()));
            return gson.toJson(response, Message.class);
        });
        Spark.exception(Exception.class, (exception, request, response) -> {
            exception.printStackTrace();
        });
    }

    private Message convertMessage(String msg) {
        Message m =  gson.fromJson(msg, Message.class);
        return m;
    }

    public String printInfo() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("color", getColor());
        jsonObject.addProperty("name", getName());
        jsonObject.addProperty("keyword", getKeyword());
        return jsonObject.toString();
    }

}
