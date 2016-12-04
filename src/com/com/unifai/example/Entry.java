package com.unifai.example;

import com.unifai.core.Unifai;

public class Entry {

    public static void main(String[] args) {
        EchoNeuron neuron = Unifai.createNeuron(EchoNeuron.class);
        neuron.start();
    }

}
