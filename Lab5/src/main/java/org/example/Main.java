package org.example;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import org.example.first.First;
import org.example.fourth.Fourth;
import org.example.third.Third;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Configurator.setRootLevel(Level.DEBUG);
        // First.run();
        Third.run();
        // Fourth.run();
    }
}