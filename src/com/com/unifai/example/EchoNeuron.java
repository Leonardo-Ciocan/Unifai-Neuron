package com.unifai.example;
import com.google.common.collect.ImmutableMap;
import com.unifai.model.Neuron;
import com.unifai.model.message.Message;
import com.unifai.model.payload.ImagePayload;

public class EchoNeuron extends Neuron
{

    EchoNeuron() {
        super();
    }

    public String getName() {
        return "Echo";
    }

    public String getColor() {
        return "30,30,30";
    }

    public Message respondToMessage(Message message) {
        Message m = new Message("You said " + message);
        m.addPayload("Image 1", new ImagePayload("http://img", "some caption" , "http://url"));
        m.addPayload("Image 2", new ImagePayload("http://img2", "some caption2" , "http://url2"));
        return m;
    }

}
