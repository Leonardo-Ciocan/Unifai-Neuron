package com.unifai.core;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.unifai.model.Neuron;

public class Unifai {

    public static <T extends Neuron> T createNeuron(Class<T> neuronClass) {
        Injector injector = Guice.createInjector(new UnifaiModule());
        return injector.getInstance(neuronClass);
    }

}
