package com.unifai.example;
import com.unifai.model.Neuron;
import com.unifai.model.message.ImageMessage;
import com.unifai.model.message.Message;
import com.unifai.model.message.TextMessage;

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
        return new ImageMessage(
                "Your message said:" + message.getBody(),
                "Some caption",
                "Some url",
                "Some other url"
        );
    }

}
